package org.trade4life.core.web.dto.trading.buy;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.trade4life.core.web.dto.PaginatedResponseDto;
import org.trade4life.core.web.dto.trading.GameDto;
import org.trade4life.core.web.dto.trading.explore.GameWithOffersDto;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Get list of games that have offers request DTO")
public class GetListOfGamesThatHaveOffersByTitlePartResponseDto extends PaginatedResponseDto {

    @Schema(title = "List of games with offers")
    List<GameDto> gamesWithOffers;

}
