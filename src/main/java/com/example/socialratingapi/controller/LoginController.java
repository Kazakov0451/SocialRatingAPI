package com.example.socialratingapi.controller;

import com.example.socialratingapi.model.dto.login.LoginRequestDto;
import com.example.socialratingapi.model.dto.login.LoginResponseDto;
import com.example.socialratingapi.model.dto.student.StudentRequestDto;
import com.example.socialratingapi.model.dto.student.StudentResponseDto;
import com.example.socialratingapi.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDto> authorization(@RequestBody LoginRequestDto loginRequest) {
        final var user = loginService.authorization(loginRequest);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }
}
