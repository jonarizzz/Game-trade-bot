package org.trade4life.core.service.game;

import org.trade4life.core.model.Game;
import org.trade4life.core.model.Platform;
import org.trade4life.core.repository.GameRepository;
import org.trade4life.core.service.GameService;
import org.trade4life.core.exception.CoreException;
import org.trade4life.core.converter.ResponseMapper;
import lombok.RequiredArgsConstructor;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.trade4life.core.exception.CoreInternalErrorCode.GAME_NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ResponseMapper responseMapper;

    @Override
    public GamePropositionResponse findGameByTitlePartAndPlatform(String titleText, Platform platform, Integer propositionSize) {
        Page<Game> propositionsPage = StringUtils.isNotBlank(titleText) ?
            gameRepository.findGamesByTitlePart(titleText, PageRequest.of(0, propositionSize)) :
            gameRepository.findAllGames(PageRequest.of(0, propositionSize));

        List<Game> pageContent = propositionsPage.getContent();
        boolean isOneLineSearchResult = propositionSize > 1 && pageContent.size() == 1;

        Game game = isOneLineSearchResult ? pageContent.get(0) : null;
        return responseMapper.toGamePropositionResponse(pageContent, game, platform);
    }

    @Override
    public GameResponse findAllGamesByTitlePartAndPlatform(String titlePart, Platform platform, Pageable pageable) {
        Page<Game> gamesPage = StringUtils.isBlank(titlePart) ? gameRepository.findAllGames(pageable) :
            gameRepository.findGamesByTitlePart(titlePart, pageable);

        return responseMapper.toGameResponse(gamesPage, platform, pageable);
    }

    @Override
    public Game findGameById(String id, Platform platform) {
        return gameRepository.findGameById(id)
            .orElseThrow(() -> new CoreException(GAME_NOT_FOUND, NOT_FOUND));
    }
}
