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
import org.trade4life.stealer.service.PlayStationGameService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements PlayStationGameService {

    @Value("${logging.batch.size}")
    Integer logBatchSize;

    @Value("${ps4.api.path}")
    private String PS4_API_PATH;

    @Value("${ps4.api.path.newest}")
    private String PS4_API_PATH_NEWEST;

    private final GamesRepository gamesRepository;
    private final PlatformRepository platformRepository;

    @Override
    public void stealAllPS4Games() {

        List<GameModel> allGames = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(PS4_API_PATH, String.class);

        PlatformModel platform = platformRepository.findById(1L).get();

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(result);
            JsonNode links = rootNode.get("links");

            int iterator = 0;

            for (JsonNode gameNode : links) {
                GameModel game = mapJsonToModel(gameNode, platform);
                allGames.add(game);
                iterator++;
                if (iterator % logBatchSize == 0) {
                    gamesRepository.saveAll(allGames);
                    allGames = new ArrayList<>();
                    log.info(iterator + " games parsed");
                }
            }

        } catch (JsonProcessingException e) {
            log.error("Json processing exception occurred during the parsing of the games: " + e.getMessage());
        } catch (Exception e) {
            log.error("Exception occurred during the parsing of the games: " + e.getMessage());
        }
        log.info("All games where saved to the database");

    }

    @Override
    public void stealAllPS5Games() {
//        TODO:
    }

    protected GameModel mapJsonToModel(JsonNode gameNode, PlatformModel platform) {

//        System.out.println("Game id from store is: " + gameNode.get("id").asText());

        return GameModel.builder()
            // .id(gameNode.get("id").asText())
            .title(gameNode.get("name").asText())
            .publisher(gameNode.get("provider_name").asText())
            .storePageUrl("https://store.playstation.com/en-us/product/" + gameNode.get("id").asText())
            .storePriceUsd(
                gameNode.has("default_sku") ? Double.parseDouble(gameNode.get("default_sku").get("display_price").asText().substring(1)) : 0)
            .thumbnailUrl(gameNode.get("images").get(0).get("url").asText())
            .platform(platform)
            .build();
    }

}
