package org.trade4life.core.converter;

import org.mapstruct.Mapper;
import org.trade4life.core.model.GameModel;
import org.trade4life.core.model.OfferModel;
import org.trade4life.core.service.game.GamePropositionResponse;
import org.trade4life.core.service.game.GameResponse;
import org.trade4life.core.service.game.GameWithRelatedOffers;
import org.trade4life.core.service.offer.OfferGamesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

    // TODO: make proper usage of mapstruct

    default GameResponse toGameResponse(Page<GameModel> gamesPage, Pageable pageable) {
        return GameResponse.builder()
            .page(pageable.getPageNumber())
            .size(pageable.getPageSize())
            .totalPages(gamesPage.getTotalPages())
            .totalGames(gamesPage.getTotalElements())
            .games(gamesPage.getContent())
            .build();
    }

    default GamePropositionResponse toGamePropositionResponse(List<GameModel> propositions, GameModel game) {
        return GamePropositionResponse.builder()
            .game(game)
            .propositions(propositions)
            .build();
    }

    default OfferGamesResponse toOfferGamesResponse(Set<GameModel> games, Page<OfferModel> publishedOffers, Pageable pageable) {

        Map<GameModel, List<OfferModel>> offersByGame = publishedOffers.getContent().stream()
            .sorted(Comparator.comparing((OfferModel offer) -> offer.getGame().getId())
                .thenComparing(OfferModel::getPrice))
            .collect(Collectors.groupingBy(OfferModel::getGame));

        Set<GameWithRelatedOffers> offerGames = games.stream()
            .map(game -> GameWithRelatedOffers.builder()
                .game(game)
                .offers(offersByGame.get(game.getId()))
                .build())
            .collect(Collectors.toSet());

        return OfferGamesResponse.builder()
            .page(pageable.getPageNumber())
            .size(pageable.getPageSize())
            .totalPages(publishedOffers.getTotalPages())
            .totalOfferGames(publishedOffers.getTotalElements())
            .offerGames(offerGames)
            .build();
    }

    default OfferGamesResponse toOfferGamesResponse(Page<OfferModel> publishedOffers, Pageable pageable) {

        Set<OfferModel> offers = publishedOffers.get().collect(Collectors.toSet());

        return OfferGamesResponse.builder()
            .page(pageable.getPageNumber())
            .size(pageable.getPageSize())
            .totalPages(publishedOffers.getTotalPages())
            .totalOfferGames(publishedOffers.getTotalElements())
            .offers(offers)
            .build();
    }
}
