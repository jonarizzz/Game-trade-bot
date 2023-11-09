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
@Schema(title = "User login DTO", description = "Holds values required for registering a new user or getting the existing one")
public class UserLoginRequestDto {

    @Schema(title = "User's telegram ID", example = "1122334455")
    private Long telegramId;

    @Schema(title = "User's telegram nickname", example = "Azaratos")
    private String nickname;

    @Schema(title = "User's name", example = "Yauheni Azaronak")
    private String name;

    @Schema(title = "User's phone", example = "+375(44)1112233")
    private String phone;

}
