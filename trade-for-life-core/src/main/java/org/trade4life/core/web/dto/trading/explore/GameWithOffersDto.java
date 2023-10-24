package org.trade4life.core.web.dto.trading.explore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@Schema(title = "Game that have offers DTO")
public class GameWithOffersDto {

    @NotEmpty
    @Schema(title = "Game ID", example = "1")
    private Long gameId;

    @NotEmpty
    @Schema(title = "Game title", example = "Need for Speed")
    private String gameTitle;

    @NotEmpty
    @Schema(title = "Lowest offer's price", example = "10.00")
    private Double lowestPrice;

    @NotEmpty
    @Schema(title = "Total offer's quantity", example = "10")
    private Integer totalOffers;

}
