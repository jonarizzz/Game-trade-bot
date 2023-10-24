package org.trade4life.core.web.dto.trading.buy;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.trade4life.core.web.dto.trading.OfferDto;
import org.trade4life.core.web.dto.PaginatedResponseDto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Get list of offers for game response DTO")
public class GetListOfOffersByGameResponseDto extends PaginatedResponseDto {

    @NotEmpty
    @Schema(title = "Game ID", example = "1")
    private Long gameId;

    @NotEmpty
    @Schema(title = "Game title", example = "Need for Speed")
    private String title;

    @Schema(title = "Game's thumbnail URL", example = "https://vulcan.dl.playstation.net/ap/rnd/202306/2312/bd5071b360f6519988606bdd4ca6ac036e9cc0a1b85c90b2.png")
    private String thumbnailUrl;

    @Schema(title = "Game's store page URL", example = "https://store.playstation.com/en-us/product/UP0101-CUSA31585_00-9795983565394038")
    private String storePageUrl;

    @Schema(title = "List of offers")
    private List<OfferDto> offers;

}
