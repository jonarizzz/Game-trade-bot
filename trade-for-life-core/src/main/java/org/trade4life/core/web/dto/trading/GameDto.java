package org.trade4life.core.web.dto.trading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(title = "Game DTO", description = "Holds values describing a game")
public class GameDto {

    @Schema(title = "Game ID", example = "1")
    private Long id;

    @Schema(title = "Game title", example = "Need for speed")
    private String title;

    @Schema(
        title = "Thumbnail URL",
        example = "https://vulcan.dl.playstation.net/ap/rnd/202306/2312/bd5071b360f6519988606bdd4ca6ac036e9cc0a1b85c90b2.png")
    private String thumbnailUrl;

    @Schema(
        title = "Store page URL",
        example = "https://store.playstation.com/en-us/product/UP0101-CUSA31585_00-9795983565394038")
    private String storePageUrl;

}
