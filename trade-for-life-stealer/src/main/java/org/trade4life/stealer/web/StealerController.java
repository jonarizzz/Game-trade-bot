package org.trade4life.stealer.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trade4life.stealer.service.PlayStationGameService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StealerController {

    private final PlayStationGameService playStationGameService;

    @RequestMapping("/stealAll")
    public ResponseEntity<String> stealAll() {
        playStationGameService.stealAllPS4Games();
        return new ResponseEntity<>("Stealing of all games finished", HttpStatus.OK);
    }

}
