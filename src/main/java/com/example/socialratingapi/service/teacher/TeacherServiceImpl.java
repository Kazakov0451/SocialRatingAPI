package com.example.socialratingapi.service.teacher;

import com.example.socialratingapi.converter.TeacherConverter;
import com.example.socialratingapi.data.entity.Student;
import com.example.socialratingapi.data.entity.Teacher;
import com.example.socialratingapi.data.repository.StudentRepository;
import com.example.socialratingapi.data.repository.TeacherRepository;
import com.example.socialratingapi.exception.GenericNotFoundException;
import com.example.socialratingapi.model.dto.point.PointDto;
import com.example.socialratingapi.model.dto.teacher.TeacherRequestDto;
import com.example.socialratingapi.model.dto.teacher.TeacherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final TeacherConverter teacherConverter;
    @Override
    public List<TeacherResponseDto> getAllTeacher() {
        return teacherRepository.findAll().stream().map(teacherConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public TeacherResponseDto getByIdTeacher(Long id) {
        final var teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(id, Teacher.class));

        return teacherConverter.toDto(teacher);
    }

    @Override
    public TeacherResponseDto createTeacher(TeacherRequestDto teacherDto) {
        final var teacher = teacherConverter.toEntity(teacherDto);
        final var saveTeacher = teacherRepository.save(teacher);

        return teacherConverter.toDto(saveTeacher);
    }

    @Override
    public void teacherGivePointsStudent(PointDto pointDto) {
        final var toStudentAddPoints = studentRepository.findById(pointDto.getToId())
                .orElseThrow(() -> new GenericNotFoundException(pointDto.getToId(), Student.class));

        final var fromTeacherTakePoints = teacherRepository.findById(pointDto.getFromId())
                .orElseThrow(() -> new GenericNotFoundException(pointDto.getFromId(), Teacher.class));

        final var toUserUpdate = addPointsStudent(toStudentAddPoints, pointDto.getPoints());

        final var fromUserUpdate = takePointsTeacher(fromTeacherTakePoints, pointDto.getPoints());

        studentRepository.save(toStudentAddPoints.update(toUserUpdate));
        teacherRepository.save(fromTeacherTakePoints.update(fromUserUpdate));
    }

    @Override
    public void deleteTeacher(Long id) {
        final var teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(id, Teacher.class));

        teacherRepository.delete(teacher);
    }

    @Override
    public TeacherResponseDto updateTeacher(TeacherRequestDto userDto, Long teacherId) {
        final var teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new GenericNotFoundException(teacherId, Teacher.class));
        final var updateTeacher = teacher.update(teacherConverter.toEntity(userDto));

        teacherRepository.save(updateTeacher);

        return teacherConverter.toDto(updateTeacher);
    }

    private Teacher takePointsTeacher(Teacher teacher, Long points) {
        return Teacher.builder()
                .id(teacher.getId())
                .points(teacher.getPoints() - points)
                .build();
    }

    private Student addPointsStudent(Student student, Long points) {
        return Student.builder()
                .id(student.getId())
                .points(student.getPoints() + points)
                .build();
    }
}
