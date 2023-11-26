package com.example.socialratingapi.model.dto.Role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RoleDto {

    STUDENT("Студент"),

    TEACHER("Учитель");

    private final String role;

}
