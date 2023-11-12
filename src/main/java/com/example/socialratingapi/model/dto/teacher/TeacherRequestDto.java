package com.example.socialratingapi.model.dto.teacher;

import com.example.socialratingapi.model.dto.gender.GenderDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequestDto {

    private String firstName;
    private String lastName;
    private String surname;
    private String email;
    private String phone;
    private String position;
    private String password;
    private GenderDto gender;
    private Long points;
}
