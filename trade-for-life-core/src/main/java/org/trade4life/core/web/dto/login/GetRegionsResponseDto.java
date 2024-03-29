package org.trade4life.core.web.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(title = "Get regions response DTO", description = "Holds available regions information")
public class GetRegionsResponseDto {

    @Schema(title = "List of regions")
    private List<RegionDto> regions;
}
