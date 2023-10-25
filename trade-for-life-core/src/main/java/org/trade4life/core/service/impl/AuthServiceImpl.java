package org.trade4life.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.trade4life.core.converter.UserMapper;
import org.trade4life.core.model.UserModel;
import org.trade4life.core.service.AuthService;
import org.trade4life.core.service.UserService;
import org.trade4life.core.web.dto.login.UserLoginRequestDto;
import org.trade4life.core.web.dto.login.UserLoginResponseDto;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final UserMapper mapper;

    @Override
    public UserLoginResponseDto login(UserLoginRequestDto loginRequestDto) {

        Optional<UserModel> userModelOptional = userService.getUserByTelegramId(loginRequestDto.getTelegramId());

        if (userModelOptional.isEmpty()) {
            UserModel user = mapper.toModel(loginRequestDto);
            user = userService.saveUser(user);

            UserLoginResponseDto responseDto = mapper.toDto(user);
            responseDto.setNew(true);
            return responseDto;
        }

        UserModel user = userModelOptional.get();

        if (!user.getNickname().equals(loginRequestDto.getNickname())) {
            user.setNickname(loginRequestDto.getNickname());
            user = userService.saveUser(user);
        }

        return mapper.toDto(user);
    }
}
