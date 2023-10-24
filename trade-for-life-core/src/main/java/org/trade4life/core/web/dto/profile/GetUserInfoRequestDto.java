package org.trade4life.core.web.dto.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@Schema(title = "Get User personal information request DTO")
public class GetUserInfoRequestDto {

    @NotEmpty
    @Schema(
        title = "User ID",
        example = "1")
    private Long userId;
}
