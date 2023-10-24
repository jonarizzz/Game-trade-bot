package org.trade4life.core.web.dto.trading.buy;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.trade4life.core.web.dto.PaginatedRequestDto;

import javax.validation.constraints.NotEmpty;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Get list of offers for game request DTO")
public class GetListOfOffersByGameRequestDto extends PaginatedRequestDto {

    @NotEmpty
    @Schema(title = "Game ID", example = "1")
    private Long gameId;

    @NotEmpty
    @Schema(title = "User ID", example = "1", description = "Used to get User's region")
    private Long userId;

}
