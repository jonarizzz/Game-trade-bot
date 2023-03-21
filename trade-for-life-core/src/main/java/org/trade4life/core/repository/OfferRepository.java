package org.trade4life.core.repository;

import org.trade4life.core.model.Offer;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer, String> {
    // Page<Offer> findOffersByStatus(OfferStatus offerStatus, Pageable pageable);
    //
    // Page<Offer> findOffersByStatusAndTelegramUserId(OfferStatus offerStatus,
    // String telegramId, Pageable pageable);
    //
    // Page<Offer> findOffersByGameId(String gameId, Pageable pageable);
    //
    // Optional<Offer> findOfferById(String id);
}
