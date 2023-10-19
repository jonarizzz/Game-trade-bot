package org.trade4life.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.trade4life.core.model.GameModel;

import java.util.Optional;
import java.util.Set;

@Repository
public interface GameRepository extends CrudRepository<GameModel, Long> {

    Page<GameModel> findAll(Pageable pageable);

    Page<GameModel> findGamesByTitleContains(String title, Pageable pageable);

    Set<GameModel> findGamesByIdIn(Set<Long> gameId);

    Optional<GameModel> findGameById(Long id);
}
