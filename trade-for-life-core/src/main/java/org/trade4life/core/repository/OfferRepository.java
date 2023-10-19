package org.trade4life.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.trade4life.core.model.OfferModel;

import java.util.Optional;

@Repository
public interface OfferRepository extends CrudRepository<OfferModel, Long> {
    Page<OfferModel> findOffersByUserTelegramId(String telegramId, Pageable pageable);

    Page<OfferModel> findOffersByGameId(Long gameId, Pageable pageable);

    Optional<OfferModel> findOfferById(Long id);
}
