package org.trade4life.bot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.trade4life.bot.dto.LoginRequestDto;
import org.trade4life.bot.dto.LoginResponseDto;
import org.trade4life.bot.service.AuthService;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    // TODO: url from properties
    private final WebClient webClient;

    @Override
    public LoginResponseDto loginUser(LoginRequestDto requestDto) {

        return webClient.post()
            .uri("http://localhost:8080/api/v1/auth/login")
            .body(Mono.just(requestDto), LoginRequestDto.class)
            .retrieve()
//                TODO: handle exceptions
//            .onStatus(HttpStatus::is5xxServerError,
//                    response -> {
//                        log.error("Failed to validate token due to TASS server error");
//                        throw new IdmException(IdmErrorCodeEnum.TASS_INTERNAL_SERVER_ERROR);
//                    })
//            .onStatus(HttpStatus.BAD_REQUEST::equals,
//                    response -> {
//                        log.error("Invalid token");
////                        throw new IdmException(IdmErrorCodeEnum.TASS_INVALID_TOKEN);
//                    })
            .bodyToMono(LoginResponseDto.class)
            .block();
    }
}
