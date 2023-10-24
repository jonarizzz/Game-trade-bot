package org.trade4life.core.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trade4life.core.web.dto.login.SetUserRegionRequestDto;
import org.trade4life.core.web.dto.profile.GetUserInfoResponseDto;
import org.trade4life.core.web.dto.profile.GetUserOffersResponseDto;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserInfoResponseDto> setUserRegion(@PathVariable String userId) {
        return null;
    }

    @PutMapping("/updateRegion")
    public ResponseEntity<String> changeUserRegion(){
        // TODO: plan first
        return null;
    }

    @PostMapping("/setRegion")
    public ResponseEntity<String> setUserRegion(@RequestBody SetUserRegionRequestDto userLoginRequestDto) {
        return null;
    }

    @GetMapping("/offers")
    public ResponseEntity<GetUserOffersResponseDto> getUserOffers(
            @RequestParam Long userId,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortOrder) {
        return null;
    }

    @PutMapping("/offers")
    public ResponseEntity<String> changeOfferPrice(
            @RequestParam Long userId,
            @RequestParam Long offerId,
            @RequestParam Double newPrice) {
        return null;
    }

    @DeleteMapping("/offers")
    public ResponseEntity<String> deleteOffer(
            @RequestParam Long userId,
            @RequestParam Long offerId) {
        return null;
    }
}
