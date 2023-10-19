package org.trade4life.core.service.offer;

import org.trade4life.core.model.OfferModel;
import org.trade4life.core.service.game.GameWithRelatedOffers;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "OfferGamesResponse", description = "Offer games search result")
public class OfferGamesResponse {
    @ApiModelProperty(position = 1, example = "1")
    private Integer page;
    @ApiModelProperty(position = 2, example = "3")
    private Integer size;
    @ApiModelProperty(position = 3, example = "5")
    private Integer totalPages;
    @ApiModelProperty(position = 4, example = "7")
    private Long totalOfferGames;
    @ApiModelProperty(position = 5)
    private Set<GameWithRelatedOffers> offerGames;
    @ApiModelProperty(position = 6)
    private Set<OfferModel> offers;
}
