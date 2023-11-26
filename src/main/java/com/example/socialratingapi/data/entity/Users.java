package com.example.socialratingapi.data.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "public")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "group_student")
    private String group;

    @Column(name = "faculty")
    private String faculty;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "points")
    private Long points;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    public Users update(Users updated) {
        return Users.builder()
                .id(id)
                .createdAt(createdAt)
                .password(password)
                .name(updated.getName() != null
                        ? updated.getName()
                        : name)
                .surname(updated.getSurname() != null
                        ? updated.getSurname()
                        : surname)
                .patronymic(updated.getPatronymic() != null
                        ? updated.getPatronymic()
                        : patronymic)
                .mail(updated.getMail() != null
                        ? updated.getMail()
                        : mail)
                .phone(updated.getPhone() != null
                        ? updated.getPhone()
                        : phone)
                .role(updated.getRole() != null
                        ? updated.getRole()
                        : role)
                .group(updated.getGroup() != null
                        ? updated.getGroup()
                        : group)
                .faculty(updated.getFaculty() != null
                        ? updated.getFaculty()
                        : faculty)
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

    @RequiredArgsConstructor
    @Getter
    public enum Role {

        STUDENT("Студент"),

        TEACHER("Учитель");

        private final String stringValue;
    }
}

