package org.trade4life.stealer.repository;

import org.trade4life.stealer.model.GameModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends CrudRepository<GameModel, String> {

}
