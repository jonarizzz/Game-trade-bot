package org.trade4life.core.web.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Get regions response DTO", description = "Holds available regions information")
public class SetUserRegionRequestDto {

    @Schema(title = "User ID", example = "1")
    private Long userId;

    @Schema(title = "Region ID", example = "1")
    private Long regionId;
}
