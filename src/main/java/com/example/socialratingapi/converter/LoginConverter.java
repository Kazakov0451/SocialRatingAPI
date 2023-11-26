package com.example.socialratingapi.converter;

import com.example.socialratingapi.data.entity.Users;
import com.example.socialratingapi.model.dto.Role.RoleDto;
import com.example.socialratingapi.model.dto.gender.GenderDto;
import com.example.socialratingapi.model.dto.login.LoginResponseDto;
import org.springframework.stereotype.Component;

@Component
public class LoginConverter {
    public LoginResponseDto toDto(Users user) {
        if (user == null) {
            return null;
        }

        return LoginResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .patronymic(user.getPatronymic())
                .password(user.getPassword())
                .mail(user.getMail())
                .phone(user.getPhone())
                .role(user.getRole() != null
                        ? RoleDto.valueOf(user.getRole().name())
                        : null)
                .group(user.getGroup())
                .faculty(user.getFaculty())
                .gender(user.getGender() != null
                        ? GenderDto.valueOf(user.getGender().name())
                        : null)
                .points(user.getPoints())
                .build();

    }
}
