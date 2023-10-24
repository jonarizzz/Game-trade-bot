package org.trade4life.core.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trade4life.core.web.dto.login.GetRegionsResponseDto;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    @GetMapping
    public ResponseEntity<GetRegionsResponseDto> getRegions() {
        return null;
    }

}
