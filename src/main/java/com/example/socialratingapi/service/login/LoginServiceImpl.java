package com.example.socialratingapi.service.login;

import com.example.socialratingapi.converter.LoginConverter;
import com.example.socialratingapi.data.repository.UsersRepository;
import com.example.socialratingapi.model.dto.login.LoginRequestDto;
import com.example.socialratingapi.model.dto.login.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final UsersRepository usersRepository;
    private final LoginConverter loginConverter;

    @Override
    public LoginResponseDto authorization(LoginRequestDto loginRequestDto) {
        final var user = usersRepository.findByMail(loginRequestDto.getMail());
        if (user != null) {
            return loginConverter.toDto(user);
        }
        return null;
    }
}
