package org.trade4life.core.service;

import org.trade4life.core.model.Game;
import org.trade4life.core.model.Platform;
import org.trade4life.core.service.game.GamePropositionResponse;
import org.trade4life.core.service.game.GameResponse;
import org.springframework.data.domain.Pageable;

public interface GameService {
    GamePropositionResponse findGameByTitlePartAndPlatform(String titlePart, Platform platform, Integer size);

    GameResponse findAllGamesByTitlePartAndPlatform(String titlePart, Platform platform, Pageable pageable);

    Game findGameById(String id, Platform platform);
}
