package com.example.socialratingapi.service.students;

import com.example.socialratingapi.converter.StudentConverter;
import com.example.socialratingapi.data.entity.Users;
import com.example.socialratingapi.data.repository.UsersRepository;
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
    private final UsersRepository usersRepository;
    private final StudentConverter studentConverter;

    @Override
    public List<StudentResponseDto> getAllStudent() {
        return usersRepository.findAllByRole(Users.Role.STUDENT)
                .stream().map(studentConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto getByIdStudent(Long id) {
        final var student = usersRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(id, Users.class));
        return studentConverter.toDto(student);
    }

    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentDto) {
        final var student = studentConverter.toEntity(studentDto);
        final var saveStudent = usersRepository.save(student);

        return studentConverter.toDto(saveStudent);
    }

    @Override
    public StudentResponseDto updateStudent(StudentRequestDto studentDto, Long studentId) {
        final var student = usersRepository.findById(studentId)
                .orElseThrow(() -> new GenericNotFoundException(studentId, Users.class));
        final var updateStudent = student.update(studentConverter.toEntity(studentDto));

        usersRepository.save(updateStudent);

        return studentConverter.toDto(updateStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        final var student = usersRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(id, Users.class));

        usersRepository.delete(student);
    }

    @Override
    public void studentGivePointsTeacher(PointDto pointDto) {
        final var toTeacherAddPoints = usersRepository.findById(pointDto.getToId())
                .orElseThrow(() -> new GenericNotFoundException(pointDto.getToId(), Users.class));

        final var fromStudentTakePoints = usersRepository.findById(pointDto.getFromId())
                .orElseThrow(() -> new GenericNotFoundException(pointDto.getFromId(), Users.class));

        final var toUserUpdate = addPointsTeacher(toTeacherAddPoints, pointDto.getPoints());

        final var fromUserUpdate = takePointsStudent(fromStudentTakePoints, pointDto.getPoints());

        usersRepository.save(toTeacherAddPoints.update(toUserUpdate));
        usersRepository.save(fromStudentTakePoints.update(fromUserUpdate));
    }

    private Users takePointsStudent(Users user, Long points) {
        return Users.builder()
                .id(user.getId())
                .points(user.getPoints() - points)
                .build();
    }

    private Users addPointsTeacher(Users user, Long points) {
        return Users.builder()
                .id(user.getId())
                .points(user.getPoints() + points)
                .build();
    }
}
