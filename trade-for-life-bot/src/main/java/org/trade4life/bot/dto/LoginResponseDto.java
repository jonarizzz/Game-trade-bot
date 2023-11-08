package org.trade4life.bot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class LoginResponseDto {

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("isNew")
    private Boolean isNew;
}
