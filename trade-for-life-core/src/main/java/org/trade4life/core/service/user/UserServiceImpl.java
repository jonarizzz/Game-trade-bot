package org.trade4life.core.service.user;

import org.trade4life.core.model.UserModel;
import org.trade4life.core.repository.UserRepository;
import org.trade4life.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserModel findUserById(Long id) {
        Optional<UserModel> userModelOptional = userRepository.findUserById(id);
        return userModelOptional.orElseThrow(RuntimeException::new);
    }

    @Override
    public UserModel findUserByTelegramId(String telegramId) {
        Optional<UserModel> userModelOptional = userRepository.findUserByTelegramId(telegramId);
        return userModelOptional.orElseThrow(RuntimeException::new);
    }

    @Override
    public UserModel findUserByNickname(String nickname) {
        Optional<UserModel> userModelOptional = userRepository.findUserByNickname(nickname);
        return userModelOptional.orElseThrow(RuntimeException::new);
    }

    @Override
    public UserResponse findUsers(Pageable pageable) {
        return UserResponse.builder()
            .page(pageable.getPageNumber())
            .size(pageable.getPageSize())
            .users(userRepository.findAll(pageable))
            .build();
    }

    @Override
    public UserModel addNewUser(UserModel user) {
        if (user.getId() != null) {
            return updateUser(user);
        }
        return userRepository.save(user);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        userRepository.findUserByTelegramId(user.getTelegramId())
            .orElseThrow(RuntimeException::new);
        return userRepository.save(user);
    }

}
