package com.example.socialratingapi.model.dto.login;

import com.example.socialratingapi.model.dto.Role.RoleDto;
import com.example.socialratingapi.model.dto.gender.GenderDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LoginResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String mail;
    private String phone;
    private String group;
    private RoleDto role;
    private String faculty;
    private String password;
    private GenderDto gender;
    private Long points;
}
