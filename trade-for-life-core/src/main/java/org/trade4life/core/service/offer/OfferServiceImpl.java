package org.trade4life.core.service.offer;

import org.trade4life.core.model.Game;
import org.trade4life.core.model.Offer;
import org.trade4life.core.model.OfferStatus;
import org.trade4life.core.model.Platform;
import org.trade4life.core.repository.GameRepository;
import org.trade4life.core.repository.OfferRepository;
import org.trade4life.core.service.OfferService;
import org.trade4life.core.exception.CoreException;
import org.trade4life.core.converter.ResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.trade4life.core.exception.CoreInternalErrorCode;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final GameRepository gameRepository;
    private final ResponseMapper responseMapper;

    @Override
    public OfferGamesResponse findOffersByStatus(OfferStatus offerStatus, Pageable pageable) {
        Page<Offer> publishedOffers = offerRepository.findOffersByStatus(OfferStatus.PUBLISHED, pageable);
        Set<String> gameIds = publishedOffers.getContent().stream()
            .map(Offer::getGameId)
            .collect(Collectors.toSet());

        Set<Game> games = gameRepository.findGamesByIdIn(gameIds);
        return responseMapper.toOfferGamesResponse(games, publishedOffers, Platform.PSN, pageable);
    }

    @Override
    public OfferGamesResponse findOffersByStatusAndTelegramId(OfferStatus offerStatus, String telegramId, Pageable pageable) {
        Page<Offer> publishedUserOffers = offerRepository.findOffersByStatusAndTelegramUserId(OfferStatus.PUBLISHED, telegramId,
            pageable);
        Set<String> gameIds = publishedUserOffers.getContent().stream()
            .map(Offer::getGameId)
            .collect(Collectors.toSet());

        Set<Game> games = gameRepository.findGamesByIdIn(gameIds);
        return responseMapper.toOfferGamesResponse(games, publishedUserOffers, Platform.PSN, pageable);
    }

    @Override
    public Offer findOfferById(String offerId) {
        return offerRepository.findOfferById(offerId)
            .orElseThrow(() -> new CoreException(CoreInternalErrorCode.OFFER_NOT_FOUND, NOT_FOUND));
    }

    @Override
    public OfferGamesResponse findOfferByGameId(String gameId, Pageable pageable) {
        Page<Offer> offers = offerRepository.findOffersByGameId(gameId, pageable);
        return responseMapper.toOfferGamesResponse(offers, Platform.PSN, pageable);
    }

    @Override
    public Offer addNewOffer(Offer offer) {
        if (offer.getId() != null) {
            return updateOffer(offer);
        }
        offer.setStatus(OfferStatus.PUBLISHED);
        return offerRepository.save(offer);
    }

    @Override
    public Offer updateOffer(Offer offer) {
        offerRepository.findOfferById(offer.getId())
            .orElseThrow(() -> new CoreException(CoreInternalErrorCode.OFFER_NOT_FOUND, NOT_FOUND));
        return offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(String offerId) {
        offerRepository.deleteById(offerId);
    }
}
