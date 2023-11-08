package org.trade4life.bot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.trade4life.bot.dto.GetRegionResponseDto;
import org.trade4life.bot.dto.RegionDto;
import org.trade4life.bot.service.RegionService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final WebClient webClient;

    @Override
    public List<RegionDto> getListOfRegions() {


        GetRegionResponseDto responseDto = webClient.get()
                .uri("http://localhost:8080/api/v1/region")
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
                .bodyToMono(GetRegionResponseDto.class)
                .block();

        if (responseDto == null || responseDto.getRegions() == null) {
            return new ArrayList<>();
        } else {
            return responseDto.getRegions();
        }
    }
}
