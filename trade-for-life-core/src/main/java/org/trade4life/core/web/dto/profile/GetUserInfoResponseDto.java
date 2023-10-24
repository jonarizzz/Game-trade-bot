package org.trade4life.core.web.dto.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@Schema(title = "Get User's personal information response DTO", description = "Holds User's personal information")
public class GetUserInfoResponseDto {

    @NotEmpty
    @Schema(
        title = "User's nickname",
        example = "Azaratos")
    private String nickname;

    @NotEmpty
    @Schema(
        title = "User's offer count",
        example = "5")
    private Integer offerCount;

}
