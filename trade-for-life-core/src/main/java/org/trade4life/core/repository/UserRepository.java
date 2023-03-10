package org.trade4life.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.trade4life.core.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserById(String id);

    List<User> findAllUsers(Pageable pageable);

    Optional<User> findUserByNickname(String nickname);

    Optional<User> findUserByTelegramId(String telegramId);
}
