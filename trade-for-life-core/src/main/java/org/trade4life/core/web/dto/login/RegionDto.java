package org.trade4life.core.web.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@Schema(title = "Region DTO")
public class RegionDto {

    @NotEmpty
    @Schema(
        title = "Region ID",
        example = "1")
    private Long id;

    @NotEmpty
    @Schema(
        title = "Region name",
        example = "Belarus")
    private String name;

    @NotEmpty
    @Schema(
        title = "Region currency",
        example = "BYN")
    private String currency;

}
