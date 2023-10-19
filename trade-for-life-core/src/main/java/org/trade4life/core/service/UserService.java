package org.trade4life.core.service;

import org.trade4life.core.model.UserModel;
import org.trade4life.core.service.user.UserResponse;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserModel findUserById(Long id);

    UserModel findUserByTelegramId(String telegramId);

    UserModel findUserByNickname(String nickname);

    UserResponse findUsers(Pageable pageable);

    UserModel addNewUser(UserModel user);

    UserModel updateUser(UserModel user);
}
