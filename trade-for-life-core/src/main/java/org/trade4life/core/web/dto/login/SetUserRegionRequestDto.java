package org.trade4life.core.web.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@Schema(title = "Get regions response DTO", description = "Holds available regions information")
public class SetUserRegionRequestDto {

    @NotEmpty
    @Schema(
        title = "User ID",
        example = "1")
    private Long userId;

    @NotEmpty
    @Schema(
        title = "Region ID",
        example = "1")
    private Long regionId;
}
