package org.trade4life.core.service;

import org.trade4life.core.model.UserModel;

import java.util.Optional;

public interface UserService {

    Optional<UserModel> getUserByTelegramId(String telegramId);

    UserModel saveUser(UserModel user);

}
