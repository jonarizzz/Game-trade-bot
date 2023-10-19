package org.trade4life.core.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.trade4life.core.model.UserModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    Optional<UserModel> findUserById(Long id);

    List<UserModel> findAll(Pageable pageable);

    Optional<UserModel> findUserByNickname(String nickname);

    Optional<UserModel> findUserByTelegramId(String telegramId);
}
