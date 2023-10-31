package org.trade4life.core.web.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(title = "User login response DTO", description = "Holds login results")
public class UserLoginResponseDto {

    @Schema(title = "User ID", example = "1")
    private Long userId;

    @Schema(title = "New user flag", example = "true")
    private Boolean isNew;

}
