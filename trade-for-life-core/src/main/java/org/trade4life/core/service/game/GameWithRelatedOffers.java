package org.trade4life.core.service.game;

import org.trade4life.core.model.Game;
import org.trade4life.core.model.Offer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "GameWithRelatedOffers", description = "Game with related public offers")
public class GameWithRelatedOffers {
    @ApiModelProperty(position = 1, allowableValues = "PSN, ESHOP", example = "PSN")
    private Game game;
    @ApiModelProperty(position = 2)
    private List<Offer> offers;
}
