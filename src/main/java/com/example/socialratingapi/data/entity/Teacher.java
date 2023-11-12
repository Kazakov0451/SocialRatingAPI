package com.example.socialratingapi.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher", schema = "public")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "position_teacher", nullable = false)
    private String position;

    @Column(name = "password")
    private String password;

    @Column(name = "points")
    private Long points;

    @Enumerated(EnumType.STRING)
    private Teacher.Gender gender;

    public Teacher update(Teacher updated) {
        return Teacher.builder()
                .id(id)
                .createdAt(createdAt)
                .password(password)
                .firstName(updated.getFirstName() != null
                        ? updated.getFirstName()
                        : firstName)
                .lastName(updated.getLastName() != null
                        ? updated.getLastName()
                        : lastName)
                .surname(updated.getSurname() != null
                        ? updated.getSurname()
                        : surname)
                .email(updated.getEmail() != null
                        ? updated.getEmail()
                        : email)
                .phone(updated.getPhone() != null
                        ? updated.getPhone()
                        : phone)
                .position(updated.getPosition() != null
                        ? updated.getPosition()
                        : position)
                .gender(updated.getGender() != null
                        ? updated.getGender()
                        : gender)
                .points(updated.getPoints() != null
                        ? updated.getPoints()
                        : points)
                .build();
    }

    @RequiredArgsConstructor
    @Getter
    public enum Gender {

        MEN("Мужской"),

        WOMEN("Женский");

        private final String stringValue;
    }
}
