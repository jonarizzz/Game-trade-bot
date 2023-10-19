package org.trade4life.core.service.offer;

import org.springframework.data.domain.Page;
import org.trade4life.core.converter.ResponseMapper;
import org.trade4life.core.model.GameModel;
import org.trade4life.core.model.OfferModel;
import org.trade4life.core.repository.GameRepository;
import org.trade4life.core.repository.OfferRepository;
import org.trade4life.core.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final GameRepository gameRepository;
    private final ResponseMapper responseMapper;

    @Override
    public OfferGamesResponse findAll(Pageable pageable) {
        Page<OfferModel> publishedOffers = offerRepository.findAll(pageable);
        var a = offerRepository.findAll();
        Set<Long> gameIds = publishedOffers.getContent().stream()
         .map(offerModel -> offerModel.getGame().getId())
         .collect(Collectors.toSet());

        Set<GameModel> games = gameRepository.findGamesByIdIn(gameIds);

        return responseMapper.toOfferGamesResponse(games, publishedOffers, pageable);
    }

    @Override
    public OfferGamesResponse findOffersByTelegramId(String telegramId, Pageable pageable) {
        Page<OfferModel> publishedUserOffers = offerRepository.findOffersByUserTelegramId(telegramId, pageable);
        Set<Long> gameIds = publishedUserOffers.getContent().stream()
            .map(offerModel -> offerModel.getGame().getId())
            .collect(Collectors.toSet());

        Set<GameModel> games = gameRepository.findGamesByIdIn(gameIds);
        return responseMapper.toOfferGamesResponse(games, publishedUserOffers, pageable);
    }

    @Override
    public OfferModel findOfferById(Long offerId) {
        return offerRepository.findOfferById(offerId)
            .orElseThrow(RuntimeException::new);
    }

    @Override
    public OfferGamesResponse findOfferByGameId(Long gameId, Pageable pageable) {
        Page<OfferModel> offers = offerRepository.findOffersByGameId(gameId, pageable);
        return responseMapper.toOfferGamesResponse(offers, pageable);
    }

    @Override
    public OfferModel addNewOffer(OfferModel offer) {
        if (offer.getId() != null) {
            return updateOffer(offer);
        }
        return offerRepository.save(offer);
    }

    @Override
    public OfferModel updateOffer(OfferModel offer) {
        offerRepository.findOfferById(offer.getId())
            .orElseThrow(RuntimeException::new);
        return offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(Long offerId) {
        offerRepository.deleteById(offerId);
    }
}
