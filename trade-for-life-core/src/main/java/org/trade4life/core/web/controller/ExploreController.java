package org.trade4life.core.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trade4life.core.web.dto.trading.buy.GetListOfOffersByGameResponseDto;
import org.trade4life.core.web.dto.trading.explore.GetListOfGamesThatHaveOffersResponseDto;

@RestController
@RequestMapping("/api/v1/trading/explore")
public class ExploreController {

    @GetMapping("/games")
    public ResponseEntity<GetListOfGamesThatHaveOffersResponseDto> getListOfGamesThatHaveOffers(
        @RequestParam Long userId,
        @RequestParam Integer page,
        @RequestParam Integer size,
        @RequestParam String sortOrder) {
        return null;
    }

    @GetMapping("/offers")
    public ResponseEntity<GetListOfOffersByGameResponseDto> getListOfOffersForGame(
        @RequestParam Long userId,
        @RequestParam Long gameId,
        @RequestParam Integer page,
        @RequestParam Integer size,
        @RequestParam String sortOrder) {
        return null;
    }

}
