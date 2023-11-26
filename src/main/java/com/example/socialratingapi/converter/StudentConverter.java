package com.example.socialratingapi.converter;

import com.example.socialratingapi.data.entity.Users;
import com.example.socialratingapi.model.dto.Role.RoleDto;
import com.example.socialratingapi.model.dto.student.StudentRequestDto;
import com.example.socialratingapi.model.dto.student.StudentResponseDto;
import com.example.socialratingapi.model.dto.gender.GenderDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StudentConverter {

    public StudentResponseDto toDto(Users student) {
        if (student == null) {
            return null;
        }

        return StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .patronymic(student.getPatronymic())
                .password(student.getPassword())
                .mail(student.getMail())
                .phone(student.getPhone())
                .role(student.getRole() != null
                        ? RoleDto.valueOf(student.getRole().name())
                        : null)
                .group(student.getGroup())
                .faculty(student.getFaculty())
                .gender(student.getGender() != null
                        ? GenderDto.valueOf(student.getGender().name())
                        : null)
                .points(student.getPoints())
                .build();

    }

    public Users toEntity(StudentRequestDto studentDto) {
        if (studentDto == null) {
            return null;
        }

        return Users.builder()
                .createdAt(LocalDateTime.now())
                .name(studentDto.getName())
                .surname(studentDto.getSurname())
                .patronymic(studentDto.getPatronymic())
                .password(studentDto.getPassword())
                .mail(studentDto.getMail())
                .phone(studentDto.getPhone())
                .group(studentDto.getGroup())
                .role(studentDto.getRole() != null
                        ? Users.Role.valueOf(studentDto.getRole().name())
                        : null)
                .faculty(studentDto.getFaculty())
                .points(studentDto.getPoints())
                .gender(studentDto.getGender() != null
                        ? Users.Gender.valueOf(studentDto.getGender().name())
                        : null)
                .build();

    }
}
