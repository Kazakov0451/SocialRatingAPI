package com.example.socialratingapi.service.students;

import com.example.socialratingapi.converter.StudentConverter;
import com.example.socialratingapi.data.entity.Student;
import com.example.socialratingapi.data.entity.Teacher;
import com.example.socialratingapi.data.repository.StudentRepository;
import com.example.socialratingapi.data.repository.TeacherRepository;
import com.example.socialratingapi.exception.GenericNotFoundException;
import com.example.socialratingapi.model.dto.point.PointDto;
import com.example.socialratingapi.model.dto.student.StudentRequestDto;
import com.example.socialratingapi.model.dto.student.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final StudentConverter studentConverter;

    @Override
    public List<StudentResponseDto> getAllStudent() {
        return studentRepository.findAll().stream().map(studentConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto getByIdStudent(Long id) {
        final var student = studentRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(id, Student.class));
        return studentConverter.toDto(student);
    }

    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentDto) {
        final var student = studentConverter.toEntity(studentDto);
        final var saveStudent = studentRepository.save(student);

        return studentConverter.toDto(saveStudent);
    }

    @Override
    public StudentResponseDto updateStudent(StudentRequestDto studentDto, Long studentId) {
        final var student = studentRepository.findById(studentId)
                .orElseThrow(() -> new GenericNotFoundException(studentId, Student.class));
        final var updateStudent = student.update(studentConverter.toEntity(studentDto));

        studentRepository.save(updateStudent);

        return studentConverter.toDto(updateStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        final var student = studentRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(id, Student.class));

        studentRepository.delete(student);
    }

    @Override
    public void studentGivePointsTeacher(PointDto pointDto) {
        final var toTeacherAddPoints = teacherRepository.findById(pointDto.getToId())
                .orElseThrow(() -> new GenericNotFoundException(pointDto.getToId(), Teacher.class));

        final var fromStudentTakePoints = studentRepository.findById(pointDto.getFromId())
                .orElseThrow(() -> new GenericNotFoundException(pointDto.getFromId(), Student.class));

        final var toUserUpdate = addPointsTeacher(toTeacherAddPoints, pointDto.getPoints());

        final var fromUserUpdate = takePointsStudent(fromStudentTakePoints, pointDto.getPoints());

        teacherRepository.save(toTeacherAddPoints.update(toUserUpdate));
        studentRepository.save(fromStudentTakePoints.update(fromUserUpdate));
    }

    private Student takePointsStudent(Student user, Long points) {
        return Student.builder()
                .id(user.getId())
                .points(user.getPoints() - points)
                .build();
    }

    private Teacher addPointsTeacher(Teacher user, Long points) {
        return Teacher.builder()
                .id(user.getId())
                .points(user.getPoints() + points)
                .build();
    }
}
