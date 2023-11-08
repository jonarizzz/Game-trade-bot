package org.trade4life.bot.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class GetRegionResponseDto {

    private List<RegionDto> regions;
}
