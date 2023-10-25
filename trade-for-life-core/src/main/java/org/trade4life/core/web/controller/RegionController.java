package org.trade4life.core.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trade4life.core.service.RegionService;
import org.trade4life.core.web.dto.login.GetRegionsResponseDto;

@RestController
@RequestMapping("/api/v1/region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService service;

    @GetMapping
    public ResponseEntity<GetRegionsResponseDto> getRegions() {
        GetRegionsResponseDto responseDto = service.findAll();
        return ResponseEntity.ok(responseDto);
    }

}
