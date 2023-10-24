package org.trade4life.core.web.dto.trading.sell;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.trade4life.core.web.dto.trading.OfferType;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@Schema(title = "Place an Offer request DTO")
public class PlaceOfferRequestDto {

    @NotEmpty
    @Schema(
        title = "User ID",
        example = "1")
    private Long userId;

    @NotEmpty
    @Schema(
        title = "Game ID",
        example = "1")
    private Long gameId;

    @NotEmpty
    @Schema(
        title = "Offer's price",
        example = "35.50")
    private Double price;

    @NotEmpty
    @Schema(
        title = "User ID",
        example = "1")
    private OfferType type;

    @Schema(
        title = "Offer's description",
        example = "Want to sell ASAP, price is negotiable, Minsk")
    private String description;

}
