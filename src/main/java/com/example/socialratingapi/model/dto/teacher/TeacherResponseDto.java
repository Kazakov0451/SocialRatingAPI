package com.example.socialratingapi.model.dto.teacher;

import com.example.socialratingapi.model.dto.Role.RoleDto;
import com.example.socialratingapi.model.dto.gender.GenderDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TeacherResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String mail;
    private String phone;
    private String faculty;
    private RoleDto role;
    private String password;
    private GenderDto gender;
    private Long points;
}
