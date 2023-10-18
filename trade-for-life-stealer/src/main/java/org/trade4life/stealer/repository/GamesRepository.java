package org.trade4life.stealer.repository;

import org.trade4life.stealer.model.GameModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamesRepository extends CrudRepository<GameModel, Long> {
    Optional<GameModel> findGameModelByStoreGameId(String storeGameId);
}
