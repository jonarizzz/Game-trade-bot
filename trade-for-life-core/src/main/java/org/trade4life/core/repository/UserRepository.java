package org.trade4life.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.trade4life.core.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Optional<User> findUserById(String id);
    //
    // List<User> findAllUsers(Pageable pageable);
    //
    // Optional<User> findUserByNickname(String nickname);
    //
    // Optional<User> findUserByTelegramId(String telegramId);
}
