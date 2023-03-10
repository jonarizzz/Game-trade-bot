package org.trade4life.core.repository;

import org.trade4life.core.model.Offer;
import org.trade4life.core.model.OfferStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OfferRepository extends CrudRepository<Offer, String> {
    Page<Offer> findOffersByStatus(OfferStatus offerStatus, Pageable pageable);

    Page<Offer> findOffersByStatusAndTelegramUserId(OfferStatus offerStatus, String telegramId, Pageable pageable);

    Page<Offer> findOffersByGameId(String gameId, Pageable pageable);

    Optional<Offer> findOfferById(String id);
}
