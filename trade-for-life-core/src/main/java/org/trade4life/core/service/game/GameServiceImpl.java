package org.trade4life.core.service.game;

import org.trade4life.core.model.Game;
import org.trade4life.core.model.Platform;
import org.trade4life.core.repository.GameRepository;
import org.trade4life.core.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    // private final ResponseMapper responseMapper;

    @Override
    public GamePropositionResponse findGameByTitlePartAndPlatform(String titleText, Platform platform, Integer propositionSize) {
        // Page<Game> propositionsPage = StringUtils.isEmpty(titleText)
        // ? gameRepository.findGamesByTitlePart(titleText, PageRequest.of(0,
        // propositionSize))
        // : gameRepository.findAllGames(PageRequest.of(0, propositionSize));
        //
        // List<Game> pageContent = propositionsPage.getContent();
        // boolean isOneLineSearchResult = propositionSize > 1 && pageContent.size() ==
        // 1;
        //
        // Game game = isOneLineSearchResult ? pageContent.get(0) : null;
        // return responseMapper.toGamePropositionResponse(pageContent, game, platform);
        return null;
    }

    @Override
    public GameResponse findAllGamesByTitlePartAndPlatform(String titlePart, Platform platform, Pageable pageable) {
        // Page<Game> gamesPage = StringUtils.isEmpty(titlePart) ?
        // gameRepository.findAllGames(pageable)
        // : gameRepository.findGamesByTitlePart(titlePart, pageable);
        //
        // return responseMapper.toGameResponse(gamesPage, platform, pageable);
        return null;
    }

    @Override
    public Game findGameById(String id, Platform platform) {
        // return gameRepository.findGameById(id)
        // .orElseThrow(() -> new CoreException(GAME_NOT_FOUND, NOT_FOUND));
        return null;
    }
}
