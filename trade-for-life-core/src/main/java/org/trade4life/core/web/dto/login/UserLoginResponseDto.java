package org.trade4life.core.web.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@Schema(title = "User login response DTO", description = "Holds login results")
public class UserLoginResponseDto {

    @NotEmpty
    @Schema(
        title = "User ID",
        example = "1")
    private Long userId;

    @NotEmpty
    @Schema(
        title = "New user flag",
        example = "true")
    private boolean isNew;

}
