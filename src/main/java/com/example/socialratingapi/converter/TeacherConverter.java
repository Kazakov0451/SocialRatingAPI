package com.example.socialratingapi.converter;

import com.example.socialratingapi.data.entity.Users;
import com.example.socialratingapi.model.dto.Role.RoleDto;
import com.example.socialratingapi.model.dto.teacher.TeacherRequestDto;
import com.example.socialratingapi.model.dto.teacher.TeacherResponseDto;
import com.example.socialratingapi.model.dto.gender.GenderDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TeacherConverter {

    public TeacherResponseDto toDto(Users teacher) {
        if (teacher == null) {
            return null;
        }

        return TeacherResponseDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .surname(teacher.getSurname())
                .patronymic(teacher.getPatronymic())
                .password(teacher.getPassword())
                .mail(teacher.getMail())
                .phone(teacher.getPhone())
                .faculty(teacher.getFaculty())
                .role(teacher.getRole() != null
                        ? RoleDto.valueOf(teacher.getRole().name())
                        : null)
                .gender(teacher.getGender() != null
                        ? GenderDto.valueOf(teacher.getGender().name())
                        : null)
                .points(teacher.getPoints())
                .build();

    }

    public Users toEntity(TeacherRequestDto teacherDto) {
        if (teacherDto == null) {
            return null;
        }

        return Users.builder()
                .createdAt(LocalDateTime.now())
                .name(teacherDto.getName())
                .surname(teacherDto.getSurname())
                .patronymic(teacherDto.getPatronymic())
                .password(teacherDto.getPassword())
                .mail(teacherDto.getMail())
                .phone(teacherDto.getPhone())
                .faculty(teacherDto.getFaculty())
                .role(teacherDto.getRole() != null
                        ? Users.Role.valueOf(teacherDto.getRole().name())
                        : null)
                .points(teacherDto.getPoints())
                .gender(teacherDto.getGender() != null
                        ? Users.Gender.valueOf(teacherDto.getGender().name())
                        : null)
                .build();

    }
}
