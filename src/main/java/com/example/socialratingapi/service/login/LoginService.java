package com.example.socialratingapi.service.login;

import com.example.socialratingapi.model.dto.login.LoginRequestDto;
import com.example.socialratingapi.model.dto.login.LoginResponseDto;

public interface LoginService {

    LoginResponseDto authorization(LoginRequestDto loginRequestDto);
}
