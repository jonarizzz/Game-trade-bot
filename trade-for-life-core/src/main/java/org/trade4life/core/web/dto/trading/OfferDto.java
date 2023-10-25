package org.trade4life.core.web.dto.trading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(title = "Offer DTO", description = "Stores Offer's information")
public class OfferDto {

    @Schema(title = "Offer ID", example = "1")
    private Long id;

    @Schema(title = "User ID", example = "1")
    private Long userId;

    @Schema(title = "Seller's telegram username", example = "Azaratos")
    private String sellerTelegramUsername;

    @Schema(title = "Offer's price", example = "12.00")
    private Double price;

    @Schema(title = "Offer's description", example = "Want to sell ASAP, price is negotiable, Minsk")
    private String description;

}
