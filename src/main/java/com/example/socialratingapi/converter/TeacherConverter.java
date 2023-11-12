package com.example.socialratingapi.converter;

import com.example.socialratingapi.data.entity.Teacher;
import com.example.socialratingapi.model.dto.teacher.TeacherRequestDto;
import com.example.socialratingapi.model.dto.teacher.TeacherResponseDto;
import com.example.socialratingapi.model.dto.gender.GenderDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TeacherConverter {

    public TeacherResponseDto toDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        return TeacherResponseDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .surname(teacher.getSurname())
                .password(teacher.getPassword())
                .email(teacher.getEmail())
                .phone(teacher.getPhone())
                .position(teacher.getPosition())
                .gender(teacher.getGender() != null
                        ? GenderDto.valueOf(teacher.getGender().name())
                        : null)
                .points(teacher.getPoints())
                .build();

    }

    public Teacher toEntity(TeacherRequestDto teacherDto) {
        if (teacherDto == null) {
            return null;
        }

        return Teacher.builder()
                .createdAt(LocalDateTime.now())
                .firstName(teacherDto.getFirstName())
                .lastName(teacherDto.getLastName())
                .surname(teacherDto.getSurname())
                .password(teacherDto.getPassword())
                .email(teacherDto.getEmail())
                .phone(teacherDto.getPhone())
                .position(teacherDto.getPosition())
                .points(teacherDto.getPoints())
                .gender(teacherDto.getGender() != null
                        ? Teacher.Gender.valueOf(teacherDto.getGender().name())
                        : null)
                .build();

    }
}
