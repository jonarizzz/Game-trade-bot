package org.trade4life.stealer.service.impl;

import org.trade4life.stealer.model.GameModel;
import org.trade4life.stealer.model.PlatformModel;
import org.trade4life.stealer.repository.GamesRepository;
import org.trade4life.stealer.repository.PlatformRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.trade4life.stealer.service.PlayStation4GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayStationGameServiceImpl implements PlayStation4GameService {

    @Value("${ps4.batch.size}")
    Integer ps4BatchSize;

    @Value("${ps4.api.path}")
    private String PS4_API_PATH;

    @Value("${ps4.api.path.newest}")
    private String PS4_API_PATH_NEWEST;

    private final GamesRepository gamesRepository;
    private final PlatformRepository platformRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();



    @Override
    public void stealAllPS4Games() {
        PlatformModel ps4 = platformRepository.findById(1L).get();

        try {
            int totalGames = getTotalPS4GamesCount();
            int numberOfRuns = (int) Math.ceil((double) totalGames / (double) ps4BatchSize);

            log.info(String.format("Stealing PS4 games started with the following parameters: " +
                    "total games = %s; batch size = %s; number of runs = %s;", totalGames, ps4BatchSize, numberOfRuns));

            for (int i = 0; i < numberOfRuns; i++) {
                String psnResponseJson = getGamesJsonFromPSN(ps4BatchSize * i, ps4BatchSize);
                List<GameModel> parsedGames = convertPsnResponseJsonToListOfModels(psnResponseJson, ps4);
                gamesRepository.saveAll(parsedGames);
            }

        } catch (JsonProcessingException e) {
            log.error("Json processing exception occurred: " + e.getMessage());
        }
    }

    @Override
    public void updatePS4Games() {
        PlatformModel ps4 = platformRepository.findById(1L).get();

        try {
            int totalGames = getTotalPS4GamesCount();
            int numberOfRuns = (int) Math.ceil((double) totalGames / (double) ps4BatchSize);

            log.info(String.format("Updating PS4 games started with the following parameters: " +
                    "total games = %s; batch size = %s; number of runs = %s;", totalGames, ps4BatchSize, numberOfRuns));

            for (int i = 0; i < numberOfRuns; i++) {
                String psnResponseJson = getGamesJsonFromPSN(ps4BatchSize * i, ps4BatchSize);
                List<GameModel> parsedGames = convertPsnResponseJsonToListOfModels(psnResponseJson, ps4);

                for (GameModel game : parsedGames) {
                    Optional<GameModel> gameOptional = gamesRepository.findGameModelByStoreGameId(game.getStoreGameId());
                    if (gameOptional.isEmpty()) {
                        gamesRepository.save(game);
                    }
                }

            }

        } catch (JsonProcessingException e) {
            log.error("Json processing exception occurred: " + e.getMessage());
        }
    }

    private List<GameModel> convertPsnResponseJsonToListOfModels(String psnResponseJson, PlatformModel platform) throws JsonProcessingException {
        List<GameModel> games = new ArrayList<>();

        JsonNode rootNode = mapper.readTree(psnResponseJson);
        JsonNode links = rootNode.get("links");

        for (JsonNode gameNode : links) {
            GameModel game = mapJsonToModel(gameNode, platform);
            games.add(game);
        }

        return games;
    }

    private Integer getTotalPS4GamesCount() throws JsonProcessingException {
        String psnResponseJson = getGamesJsonFromPSN(0, 1);
        JsonNode rootNode = mapper.readTree(psnResponseJson);
        return rootNode.get("total_results").asInt();
    }

    private String getGamesJsonFromPSN(int start, int size) {
        String URL = String.format(PS4_API_PATH, size, start);
        log.info(URL);
        return restTemplate.getForObject(URL, String.class);
    }

    private GameModel mapJsonToModel(JsonNode gameNode, PlatformModel platform) {

        double price = 0;
        if (gameNode.has("default_sku") &&
            !gameNode.get("default_sku").get("display_price").asText().equals("Free")) {
            price = Double.parseDouble(gameNode.get("default_sku").get("display_price").asText().substring(1));
        }

        return GameModel.builder()
            .storeGameId(gameNode.get("id").asText())
            .title(gameNode.get("name").asText())
            .publisher(gameNode.get("provider_name").asText())
            .storePageUrl("https://store.playstation.com/en-us/product/" + gameNode.get("id").asText())
            .storePriceUsd(price)
            .thumbnailUrl(gameNode.get("images").get(0).get("url").asText())
            .platform(platform)
            .build();
    }

}
