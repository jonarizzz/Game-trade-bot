package org.trade4life.core.web.controller0;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.trade4life.core.model.OfferModel;
import org.trade4life.core.service.OfferService;
import org.trade4life.core.service.offer.OfferGamesResponse;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Api(value = "core-offers", tags = "core-offers")
public class OffersController {
    private final OfferService offerService;

    @GetMapping(value = "offers/published", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferGamesResponse> getPublishedOffers(
        @RequestParam(name = "gameId", required = false) String gameId,
        @RequestParam(name = "userId", required = false) String userId,
        @RequestParam(name = "page") @NotNull Integer page,
        @RequestParam(name = "size") @NotNull @Positive Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        if (gameId != null && !gameId.isEmpty()) {
            OfferGamesResponse offers = offerService.findOfferByGameId(Long.getLong(gameId), pageable);
            return new ResponseEntity<>(offers, HttpStatus.OK);
        } else if (userId != null && !userId.isEmpty()) {
            OfferGamesResponse offers = offerService.findOffersByTelegramId(userId, pageable);
            return new ResponseEntity<>(offers, HttpStatus.OK);
        }

        return new ResponseEntity<>(offerService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping(value = "offers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferModel> publishOffer(@RequestBody @NotNull OfferModel offer) {
        OfferModel newOffer = offerService.addNewOffer(offer);
        return new ResponseEntity<>(newOffer, HttpStatus.OK);
    }


    @PutMapping(value = "offers/{offerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferModel> updateOffer(
        @RequestBody @NotNull OfferModel offer,
        @PathVariable(name = "offerId") @NotBlank Long offerId) {
        offer.setId(offerId);
        OfferModel updatedOffer = offerService.updateOffer(offer);
        return new ResponseEntity<>(updatedOffer, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "offers/{offerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteOffer(
        @PathVariable(name = "offerId") @NotBlank Long offerId) {
        // TODO: idk what to return here in response as identifier
        offerService.deleteOffer(offerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
