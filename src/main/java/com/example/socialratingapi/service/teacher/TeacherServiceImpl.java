package com.example.socialratingapi.service.teacher;

import com.example.socialratingapi.converter.TeacherConverter;
import com.example.socialratingapi.data.entity.Users;
import com.example.socialratingapi.data.repository.UsersRepository;
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
    private final UsersRepository usersRepository;
    private final TeacherConverter teacherConverter;
    @Override
    public List<TeacherResponseDto> getAllTeacher() {
        return usersRepository.findAllByRole(Users.Role.TEACHER)
                .stream().map(teacherConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public TeacherResponseDto getByIdTeacher(Long id) {
        final var teacher = usersRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(id, Users.class));

        return teacherConverter.toDto(teacher);
    }

    @Override
    public TeacherResponseDto createTeacher(TeacherRequestDto userDto) {
        final var teacher = teacherConverter.toEntity(userDto);
        final var saveTeacher = usersRepository.save(teacher);

        return teacherConverter.toDto(saveTeacher);
    }

    @Override
    public void teacherGivePointsStudent(PointDto pointDto) {
        final var toStudentAddPoints = usersRepository.findById(pointDto.getToId())
                .orElseThrow(() -> new GenericNotFoundException(pointDto.getToId(), Users.class));

        final var fromTeacherTakePoints = usersRepository.findById(pointDto.getFromId())
                .orElseThrow(() -> new GenericNotFoundException(pointDto.getFromId(), Users.class));

        final var toUserUpdate = addPointsStudent(toStudentAddPoints, pointDto.getPoints());

        final var fromUserUpdate = takePointsTeacher(fromTeacherTakePoints, pointDto.getPoints());

        usersRepository.save(toStudentAddPoints.update(toUserUpdate));
        usersRepository.save(fromTeacherTakePoints.update(fromUserUpdate));
    }

    @Override
    public void deleteTeacher(Long id) {
        final var teacher = usersRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(id, Users.class));

        usersRepository.delete(teacher);
    }

    @Override
    public TeacherResponseDto updateTeacher(TeacherRequestDto userDto, Long teacherId) {
        final var teacher = usersRepository.findById(teacherId)
                .orElseThrow(() -> new GenericNotFoundException(teacherId, Users.class));
        final var updateTeacher = teacher.update(teacherConverter.toEntity(userDto));

        usersRepository.save(updateTeacher);

        return teacherConverter.toDto(updateTeacher);
    }

    private Users takePointsTeacher(Users teacher, Long points) {
        return Users.builder()
                .id(teacher.getId())
                .points(teacher.getPoints() - points)
                .build();
    }

    private Users addPointsStudent(Users student, Long points) {
        return Users.builder()
                .id(student.getId())
                .points(student.getPoints() + points)
                .build();
    }
}
