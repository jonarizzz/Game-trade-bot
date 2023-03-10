package org.trade4life.core.service;

import org.trade4life.core.model.User;
import org.trade4life.core.service.user.UserResponse;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User findUserById(String id);

    User findUserByTelegramId(String telegramId);

    User findUserByNickname(String nickname);

    UserResponse findUsers(Pageable pageable);

    User addNewUser(User user);

    User updateUser(User user);
}
