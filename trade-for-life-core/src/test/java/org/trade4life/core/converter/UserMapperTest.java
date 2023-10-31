package org.trade4life.core.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.trade4life.core.model.UserModel;
import org.trade4life.core.web.dto.login.UserLoginResponseDto;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.trade4life.core.fixture.UserFixture.*;

class UserMapperTest {

    @Test
    public void testNullMappers() {
        Assertions.assertNull(UserMapper.INSTANCE.toDto(null));
        Assertions.assertNull(UserMapper.INSTANCE.toModel(null));
    }

    @Test
    public void shouldConvertToDto() {
        UserLoginResponseDto result = UserMapper.INSTANCE.toDto(userModel());

        assertThat(result.getUserId()).isEqualTo(USER_ID);
        assertThat(result.getIsNew()).isFalse();
    }

    @Test
    public void shouldConvertToModel() {
        UserModel result = UserMapper.INSTANCE.toModel(userLoginRequestDto());

        assertThat(result.getId()).isNull();
        assertThat(result.getTelegramId()).isEqualTo(USER_TELEGRAM_ID);
        assertThat(result.getNickname()).isEqualTo(USER_NICKNAME);
        assertThat(result.getName()).isEqualTo(USER_NAME);
        assertThat(result.getPhone()).isEqualTo(USER_PHONE);
        assertThat(result.getRegion()).isNull();
        assertThat(result.isBlocked()).isFalse();
    }

}
