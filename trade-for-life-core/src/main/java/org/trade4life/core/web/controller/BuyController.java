package org.trade4life.core.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trade4life.core.web.dto.trading.buy.GetListOfGamesThatHaveOffersByTitlePartResponseDto;
import org.trade4life.core.web.dto.trading.buy.GetListOfOffersByGameResponseDto;

@RestController
@RequestMapping("/api/v1/trading/buy")
@RequiredArgsConstructor
public class BuyController {

    @GetMapping("/games")
    public ResponseEntity<GetListOfGamesThatHaveOffersByTitlePartResponseDto> getListOfGamesByTitlePart(
        @RequestParam String titlePart,
        @RequestParam Long userId,
        @RequestParam Integer page,
        @RequestParam Integer size,
        @RequestParam String sortOrder) {
        return null;
    }

    @GetMapping("/offers")
    public ResponseEntity<GetListOfOffersByGameResponseDto> getListOfOffersByGame(
        @RequestParam Long gameId,
        @RequestParam Long userId,
        @RequestParam Integer page,
        @RequestParam Integer size,
        @RequestParam String sortOrder) {
        return null;
    }

}
