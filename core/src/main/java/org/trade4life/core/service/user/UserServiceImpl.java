package org.trade4life.core.service.user;

import org.trade4life.core.repository.UserRepository;
import org.trade4life.core.service.UserService;
import org.trade4life.core.model.User;
import org.trade4life.core.exception.CoreException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static org.trade4life.core.exception.CoreInternalErrorCode.USER_NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findUserById(String id) {
        return userRepository.findUserById(id)
            .orElseThrow(() -> new CoreException(USER_NOT_FOUND, NOT_FOUND));
    }

    @Override
    public User findUserByTelegramId(String telegramId) {
        return userRepository.findUserByTelegramId(telegramId)
            .orElseThrow(() -> new CoreException(USER_NOT_FOUND, NOT_FOUND));
    }

    @Override
    public User findUserByNickname(String nickname) {
        return userRepository.findUserByNickname(nickname)
            .orElseThrow(() -> new CoreException(USER_NOT_FOUND, NOT_FOUND));
    }

    @Override
    public UserResponse findUsers(Pageable pageable) {
        return null;
//        return UserResponse.builder()
//            .page(pageable.getPageNumber())
//            .size(pageable.getPageSize())
//            .users(userRepository.findAll(pageable).getContent())
//            .build();
    }

    @Override
    public User addNewUser(User user) {
        if (user.getId() != null) {
            return updateUser(user);
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        userRepository.findUserByTelegramId(user.getTelegramId())
            .orElseThrow(() -> new CoreException(USER_NOT_FOUND, NOT_FOUND));
        return userRepository.save(user);
    }
}
