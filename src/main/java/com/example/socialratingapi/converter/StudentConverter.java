package com.example.socialratingapi.converter;

import com.example.socialratingapi.data.entity.Student;
import com.example.socialratingapi.model.dto.student.StudentRequestDto;
import com.example.socialratingapi.model.dto.student.StudentResponseDto;
import com.example.socialratingapi.model.dto.gender.GenderDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StudentConverter {

    public StudentResponseDto toDto(Student student) {
        if (student == null) {
            return null;
        }

        return StudentResponseDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .surname(student.getSurname())
                .password(student.getPassword())
                .email(student.getEmail())
                .phone(student.getPhone())
                .group(student.getGroup())
                .faculty(student.getFaculty())
                .gender(student.getGender() != null
                        ? GenderDto.valueOf(student.getGender().name())
                        : null)
                .points(student.getPoints())
                .build();

    }

    public Student toEntity(StudentRequestDto studentDto) {
        if (studentDto == null) {
            return null;
        }

        return Student.builder()
                .createdAt(LocalDateTime.now())
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .surname(studentDto.getSurname())
                .password(studentDto.getPassword())
                .email(studentDto.getEmail())
                .phone(studentDto.getPhone())
                .group(studentDto.getGroup())
                .faculty(studentDto.getFaculty())
                .points(studentDto.getPoints())
                .gender(studentDto.getGender() != null
                        ? Student.Gender.valueOf(studentDto.getGender().name())
                        : null)
                .build();

    }
}
