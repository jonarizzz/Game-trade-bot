package org.trade4life.core.service;

import org.trade4life.core.model.GameModel;
import org.trade4life.core.service.game.GamePropositionResponse;
import org.trade4life.core.service.game.GameResponse;
import org.springframework.data.domain.Pageable;

public interface GameService {
    GamePropositionResponse findGameByTitlePart(String titlePart, Integer size);

    GameResponse findAllGamesByTitlePart(String titlePart, Pageable pageable);

    GameModel findGameById(Long id);
}
