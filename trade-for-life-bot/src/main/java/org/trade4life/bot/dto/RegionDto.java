package org.trade4life.bot.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class RegionDto {
    private Long id;
    private String nameEn;
    private String nameRu;
    private String currency;
}
