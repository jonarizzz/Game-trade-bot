package org.trade4life.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.trade4life.core.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

public interface GameRepository extends CrudRepository<Game, Long> {

//    Page<Game> findAllGames(Pageable pageable);
//
//    Page<Game> findGamesByTitlePart(String titlePart, Pageable pageable);
//
//    Set<Game> findGamesByIdIn(Set<String> gameId);
//
//    Optional<Game> findGameById(String id);
}
