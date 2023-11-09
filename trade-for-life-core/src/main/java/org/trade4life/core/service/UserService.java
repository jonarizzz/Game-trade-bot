package org.trade4life.core.service;

import org.trade4life.core.model.UserModel;
import org.trade4life.core.web.dto.login.SetUserRegionRequestDto;

import java.util.Optional;

public interface UserService {

    Optional<UserModel> getUserByTelegramId(Long telegramId);

    UserModel saveUser(UserModel user);

    void setUserRegion(SetUserRegionRequestDto setUserRegionRequestDto);

}
