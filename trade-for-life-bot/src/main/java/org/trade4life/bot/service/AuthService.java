package org.trade4life.bot.service;

import org.trade4life.bot.dto.LoginRequestDto;
import org.trade4life.bot.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto loginUser(LoginRequestDto requestDto);

}
