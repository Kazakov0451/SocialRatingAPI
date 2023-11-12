package com.example.socialratingapi.model.dto.student;

import com.example.socialratingapi.model.dto.gender.GenderDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    private String firstName;
    private String lastName;
    private String surname;
    private String email;
    private String phone;
    private String group;
    private String faculty;
    private String password;
    private GenderDto gender;
    private Long points;
}
