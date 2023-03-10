package org.trade4life.stealer.web;

import org.trade4life.stealer.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StealerController {

    private final GameService gameService;

    @RequestMapping("/stealAll")
    public ResponseEntity<String> stealAll(){
        gameService.stealAllGames();
        return new ResponseEntity<>("Stealing of all games finished", HttpStatus.OK);
    }

}
