package org.trade4life.core.fixture;

import org.trade4life.core.model.UserModel;
import org.trade4life.core.web.dto.login.UserLoginRequestDto;
import org.trade4life.core.web.dto.login.UserLoginResponseDto;

import static org.trade4life.core.fixture.RegionFixture.regionModel;

public class UserFixture {

    public static final Long USER_ID = 1998L;
    public static final String USER_TELEGRAM_ID = "11002299338844775566";
    public static final String USER_NICKNAME = "MrTester";
    public static final String USER_NAME = "Mister Tester";
    public static final String USER_PHONE = "+375(44)7724304";
    public static final String USER_BIO = "I am a tester!";

    public static UserModel userModel() {
        return userModel(USER_ID, USER_TELEGRAM_ID, USER_NICKNAME, USER_NAME, USER_PHONE, USER_BIO);
    }

    public static UserModel userModel(Long id, String telegramId, String nickname, String name, String phone, String bio) {
        return UserModel.builder()
            .id(id)
            .telegramId(telegramId)
            .nickname(nickname)
            .name(name)
            .phone(phone)
            .bio(bio)
            .region(regionModel())
            .isBlocked(false)
            .build();
    }

    public static UserModel userModelWithoutRegion() {
        return userModelWithoutRegion(USER_ID, USER_TELEGRAM_ID, USER_NICKNAME, USER_NAME, USER_PHONE, USER_BIO);
    }

    public static UserModel userModelWithoutRegion(Long id, String telegramId, String nickname, String name, String phone, String bio) {
        return UserModel.builder()
                .id(id)
                .telegramId(telegramId)
                .nickname(nickname)
                .name(name)
                .phone(phone)
                .bio(bio)
                .isBlocked(false)
                .build();
    }

    public static UserLoginRequestDto userLoginRequestDto() {
        return userLoginRequestDto(USER_TELEGRAM_ID, USER_NICKNAME, USER_NAME, USER_PHONE);
    }

    public static UserLoginRequestDto userLoginRequestDto(String telegramId, String nickname, String name, String phone) {
        return UserLoginRequestDto.builder()
            .telegramId(telegramId)
            .nickname(nickname)
            .name(name)
            .phone(phone)
            .build();
    }

    public static UserLoginResponseDto userLoginResponseDto() {
        return userLoginResponseDto(USER_ID, false);
    }

    public static UserLoginResponseDto userLoginResponseDto(Long userId, Boolean isNew) {
        return UserLoginResponseDto.builder()
            .userId(userId)
            .isNew(isNew)
            .build();
    }

}
