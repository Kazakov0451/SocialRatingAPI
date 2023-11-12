package com.example.socialratingapi.model.dto.gender;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GenderDto {

    MEN("Мужской"),

    WOMEN("Женский");

    private final String gender;

}
