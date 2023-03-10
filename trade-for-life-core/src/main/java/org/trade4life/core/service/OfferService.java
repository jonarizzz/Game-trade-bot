package org.trade4life.core.service;

import org.trade4life.core.model.Offer;
import org.trade4life.core.model.OfferStatus;
import org.trade4life.core.service.offer.OfferGamesResponse;
import org.springframework.data.domain.Pageable;

public interface OfferService {
    OfferGamesResponse findOffersByStatus(OfferStatus offerStatus, Pageable pageable);

    OfferGamesResponse findOffersByStatusAndTelegramId(OfferStatus offerStatus, String telegramId, Pageable pageable);

    Offer findOfferById(String offerId);

    OfferGamesResponse findOfferByGameId(String gameId, Pageable pageable);

    Offer addNewOffer(Offer offer);

    Offer updateOffer(Offer offer);

    void deleteOffer(String offerId);
}
