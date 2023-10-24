package org.trade4life.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.trade4life.core.model.UserModel;
import org.trade4life.core.repository.UserRepository;
import org.trade4life.core.service.UserService;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Optional<UserModel> getUserByTelegramId(String telegramId) {
        return repository.findUserByTelegramId(telegramId);
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return repository.save(user);
    }
}
