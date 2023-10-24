package org.trade4life.core.web.controller0;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.extern.slf4j.Slf4j;
import org.trade4life.core.model.GameModel;
import org.trade4life.core.service.GameService;
import org.trade4life.core.service.game.GamePropositionResponse;
import org.trade4life.core.service.game.GameResponse;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Api(value = "core-games", tags = "core-games")
@Validated
@Slf4j
public class GamesController {
    private final GameService gameService;

    @ApiOperation(value = "Get the list of game propositions by title text part", nickname = "getGamePropositions")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Error")
        })
    @GetMapping(value = "/games/propositions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePropositionResponse> getGameTitles(
        @ApiParam(name = "titleText", value = "Game title text", example = "The Witcher 3") @RequestParam(
            name = "titleText",
            required = false) String titleText,
        @ApiParam(name = "propositionSize", value = "Number of title propositions (1..N)", defaultValue = "5") @RequestParam(
            name = "propositionSize",
            defaultValue = "5") @Positive Integer propositionSize) {
        GamePropositionResponse gamePropositionResponse = gameService.findGameByTitlePart(titleText, propositionSize);
        return new ResponseEntity<>(gamePropositionResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/games", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameResponse> getGames(
        @RequestParam(name = "titlePart", required = false) String titlePart,
        @RequestParam(name = "page") @NotNull Integer page,
        @RequestParam(name = "size") @NotNull @Positive Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        GameResponse gameResponse = gameService.findAllGamesByTitlePart(titlePart, pageable);
        return new ResponseEntity<>(gameResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get the game by game id", nickname = "getGameById")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Error")
        })
    @GetMapping(value = "/games/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameModel> getGame(
        @ApiParam(name = "gameId", value = "Game id", example = "5f70948f17361f2260cb22aa", required = true) @PathVariable(
            name = "gameId") @NotBlank Long gameId) {
        GameModel game = gameService.findGameById(gameId);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }
}
