package org.trade4life.core.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trade4life.core.web.dto.login.SetUserRegionRequestDto;
import org.trade4life.core.web.dto.profile.GetUserInfoResponseDto;
import org.trade4life.core.web.dto.profile.GetUserOffersResponseDto;

@Tag(name = "3. User", description = "User controller")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Operation(summary = "Endpoint for getting User's personal information")
    @GetMapping("/{userId}")
    public ResponseEntity<GetUserInfoResponseDto> getUserInfo(@PathVariable String userId) {
        return null;
    }

    @Operation(summary = "Endpoint for assigning the region to a new User")
    @PostMapping("/setRegion")
    public ResponseEntity<String> setUserRegion(@RequestBody SetUserRegionRequestDto userLoginRequestDto) {
        return null;
    }

    @Operation(summary = "Endpoint for changing User's region")
    @PutMapping("/updateRegion")
    public ResponseEntity<String> changeUserRegion() {
        // TODO: plan first
        return null;
    }

    @Operation(summary = "Endpoint for getting the list of User's offers")
    @GetMapping("/offers")
    public ResponseEntity<GetUserOffersResponseDto> getUserOffers(
        @RequestParam Long userId,
        @RequestParam Integer page,
        @RequestParam Integer size,
        @RequestParam String sortOrder) {
        return null;
    }

    @Operation(summary = "Endpoint for changing the price on User's offer")
    @PutMapping("/offers")
    public ResponseEntity<String> changeOfferPrice(
        @RequestParam Long userId,
        @RequestParam Long offerId,
        @RequestParam Double newPrice) {
        return null;
    }

    @Operation(summary = "Endpoint for deleting User's offer")
    @DeleteMapping("/offers")
    public ResponseEntity<String> deleteOffer(
        @RequestParam Long userId,
        @RequestParam Long offerId) {
        return null;
    }
}
