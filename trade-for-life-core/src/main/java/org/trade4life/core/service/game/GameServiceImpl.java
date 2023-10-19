package org.trade4life.core.service.game;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.trade4life.core.converter.ResponseMapper;
import org.trade4life.core.model.GameModel;
import org.trade4life.core.repository.GameRepository;
import org.trade4life.core.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ResponseMapper responseMapper;

    @Override
    public GamePropositionResponse findGameByTitlePart(String titlePart, Integer size) {
        Page<GameModel> propositionsPage = titlePart.isEmpty()
            ? gameRepository.findGamesByTitleContains(titlePart, PageRequest.of(0, size))
            : gameRepository.findAll(PageRequest.of(0, size));

        List<GameModel> pageContent = propositionsPage.getContent();
        boolean isOneLineSearchResult = size > 1 && pageContent.size() == 1;

        GameModel game = isOneLineSearchResult ? pageContent.get(0) : null;
        return responseMapper.toGamePropositionResponse(pageContent, game);
    }

    @Override
    public GameResponse findAllGamesByTitlePart(String titlePart, Pageable pageable) {
        Page<GameModel> gamesPage = titlePart.isEmpty() ? gameRepository.findAll(pageable)
            : gameRepository.findGamesByTitleContains(titlePart, pageable);

        return responseMapper.toGameResponse(gamesPage, pageable);
    }

    @Override
    public GameModel findGameById(Long id) {
        return gameRepository.findGameById(id)
            .orElseThrow(RuntimeException::new);
    }

}
