package org.trade4life.core.service.game;

import org.trade4life.core.model.Game;
import org.trade4life.core.model.Platform;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "GamePropositionResponse", description = "Game search proposition")
public class GamePropositionResponse {
    @ApiModelProperty(position = 1, allowableValues = "PSN, ESHOP")
    private Platform platform = Platform.PSN;
    @ApiModelProperty(position = 2)
    private Game game;
    @ApiModelProperty(position = 3)
    private List<Game> propositions;
}
