package org.trade4life.core.service;

import org.trade4life.core.web.dto.login.UserLoginRequestDto;
import org.trade4life.core.web.dto.login.UserLoginResponseDto;

public interface AuthService {

    UserLoginResponseDto login(UserLoginRequestDto loginRequestDto);

}
