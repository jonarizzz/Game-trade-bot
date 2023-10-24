package org.trade4life.core.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trade4life.core.web.dto.trading.sell.GetListOfGamesByTitlePartResponseDto;
import org.trade4life.core.web.dto.trading.sell.PlaceOfferRequestDto;

@RestController
@RequestMapping("/api/v1/trading/sell")
public class SellController {


    @GetMapping
    public ResponseEntity<GetListOfGamesByTitlePartResponseDto> getListOfGamesByTitlePart(
            @RequestParam String titlePart,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortOrder) {
        return null;
    }

    @PostMapping
    public ResponseEntity<String> publishOffer(@RequestBody PlaceOfferRequestDto requestDto) {
        return null;
    }

}
