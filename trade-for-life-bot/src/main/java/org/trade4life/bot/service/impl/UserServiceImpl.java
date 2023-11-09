package org.trade4life.bot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.trade4life.bot.dto.SetUserRegionRequestDto;
import org.trade4life.bot.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final WebClient webClient;

    @Override
    public void setUserRegion(Long userTelegramId, Long regionId) {
        SetUserRegionRequestDto requestDto = SetUserRegionRequestDto.builder()
            .userTelegramId(userTelegramId)
            .regionId(regionId)
            .build();

        // TODO: add on-status handling
        String response = webClient.put()
            .uri("http://localhost:8080/api/v1/user/setRegion")
            .bodyValue(requestDto)
            .retrieve()
            .bodyToMono(String.class)
            .block();

        System.out.println("test");
    }
}
