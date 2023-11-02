package org.trade4life.core.web.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(title = "Region DTO")
public class RegionDto {

    @Schema(title = "Region ID", example = "1")
    private Long id;

    @Schema(title = "Region name in English", example = "Minsk")
    private String nameEn;

    @Schema(title = "Region name in Russian", example = "Минск")
    private String nameRu;

    @Schema(title = "Region currency", example = "BYN")
    private String currency;

}
