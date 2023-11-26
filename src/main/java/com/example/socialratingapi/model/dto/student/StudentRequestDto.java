package com.example.socialratingapi.model.dto.student;

import com.example.socialratingapi.model.dto.Role.RoleDto;
import com.example.socialratingapi.model.dto.gender.GenderDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    private String name;
    private String surname;
    private String patronymic;
    private String mail;
    private String phone;
    private RoleDto role;
    private String group;
    private String faculty;
    private String password;
    private GenderDto gender;
    private Long points;
}
