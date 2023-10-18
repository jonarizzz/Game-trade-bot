package org.trade4life.stealer.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trade4life.stealer.service.PlayStation4GameService;

@RestController
@RequestMapping("/steal")
@RequiredArgsConstructor
public class StealerController {

    private final PlayStation4GameService playStationGameService;

    @RequestMapping("/all/ps4")
    public ResponseEntity<String> stealAll() {
        playStationGameService.stealAllPS4Games();
        return new ResponseEntity<>("Stealing of PS4 games is finished", HttpStatus.OK);
    }

    @RequestMapping("/new/ps4")
    public ResponseEntity<String> stealNew() {
        playStationGameService.updatePS4Games();
        return new ResponseEntity<>("Updating of PS4 games is finished", HttpStatus.OK);
    }

}
