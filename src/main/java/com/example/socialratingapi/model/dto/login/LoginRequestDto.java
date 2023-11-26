package com.example.socialratingapi.model.dto.login;

import com.example.socialratingapi.model.dto.Role.RoleDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    private String mail;
    private String password;
}
