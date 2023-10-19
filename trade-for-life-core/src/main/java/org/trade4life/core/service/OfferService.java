package org.trade4life.core.service;

import org.trade4life.core.model.OfferModel;
import org.trade4life.core.service.offer.OfferGamesResponse;
import org.springframework.data.domain.Pageable;

public interface OfferService {
    OfferGamesResponse findOffersByTelegramId(String telegramId, Pageable pageable);

    OfferModel findOfferById(Long offerId);

    OfferGamesResponse findOfferByGameId(Long gameId, Pageable pageable);

    OfferModel addNewOffer(OfferModel offer);

    OfferModel updateOffer(OfferModel offer);

    void deleteOffer(Long offerId);
}
