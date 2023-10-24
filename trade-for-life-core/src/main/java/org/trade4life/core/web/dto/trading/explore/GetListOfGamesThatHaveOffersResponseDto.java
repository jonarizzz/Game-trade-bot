package org.trade4life.core.web.dto.trading.explore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.trade4life.core.web.dto.PaginatedResponseDto;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Get list of games that have offers request DTO")
public class GetListOfGamesThatHaveOffersResponseDto extends PaginatedResponseDto {

    @Schema(title = "List of games with offers")
    List<GameWithOffersDto> gamesWithOffers;

}
