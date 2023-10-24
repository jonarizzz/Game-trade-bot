package org.trade4life.core.web.dto.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(title = "Get User's personal information response DTO", description = "Holds User's personal information")
public class GetUserInfoResponseDto {

    @Schema(title = "User's nickname", example = "Azaratos")
    private String nickname;

    @Schema(title = "User's offer count", example = "5")
    private Integer offerCount;

}
