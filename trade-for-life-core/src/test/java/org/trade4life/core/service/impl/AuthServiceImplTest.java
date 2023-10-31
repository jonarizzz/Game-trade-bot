package org.trade4life.core.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.trade4life.core.converter.UserMapper;
import org.trade4life.core.model.UserModel;
import org.trade4life.core.service.UserService;
import org.trade4life.core.web.dto.login.UserLoginRequestDto;
import org.trade4life.core.web.dto.login.UserLoginResponseDto;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.trade4life.core.fixture.UserFixture.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {
    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @Spy
    @InjectMocks
    private AuthServiceImpl authService;

    @Test
    void testContextInit() {
        assertThat(userService).isNotNull();
        assertThat(userMapper).isNotNull();
        assertThat(authService).isNotNull();
    }

    @Test
    public void loginShouldCreateUserIfNotPresent() {

        when(userService.getUserByTelegramId(any())).thenReturn(Optional.empty());
        when(userMapper.toModel(any())).thenReturn(userModel());
        when(userService.saveUser(any())).thenReturn(userModel());
        when(userMapper.toDto(any())).thenReturn(userLoginResponseDto(USER_ID, null));

        UserLoginResponseDto loginResult = authService.login(userLoginRequestDto());

        verify(userService).getUserByTelegramId(eq(USER_TELEGRAM_ID));
        verify(userMapper).toModel(any(UserLoginRequestDto.class));
        verify(userService).saveUser(any(UserModel.class));
        verify(userMapper).toDto(any(UserModel.class));

        assertThat(loginResult.getUserId()).isEqualTo(USER_ID);
        assertThat(loginResult.getIsNew()).isEqualTo(true);
    }

    @Test
    public void loginShouldGetExistingUserIfExists() {
        when(userService.getUserByTelegramId(any())).thenReturn(Optional.of(userModelWithoutRegion()));
        when(userMapper.toDto(any())).thenReturn(userLoginResponseDto(USER_ID, null));

        UserLoginResponseDto loginResult = authService.login(userLoginRequestDto());

        verify(userService).getUserByTelegramId(eq(USER_TELEGRAM_ID));
        verify(userMapper).toDto(any(UserModel.class));

        assertThat(loginResult.getUserId()).isEqualTo(USER_ID);
        assertThat(loginResult.getIsNew()).isEqualTo(true);

    }

    public void loginShouldUpdateUserNicknameIfChanged() {

    }

    public void loginResultShouldSayNewUserIfUserGotNoRegion() {

    }

}
