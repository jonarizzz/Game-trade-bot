package org.trade4life.bot.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class SetUserRegionRequestDto {

    private Long userTelegramId;

    private Long regionId;

}
