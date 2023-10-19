package org.trade4life.core.service.game;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.trade4life.core.model.GameModel;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "GamePropositionResponse", description = "Game search proposition")
public class GamePropositionResponse {
    @ApiModelProperty(position = 2)
    private GameModel game;
    @ApiModelProperty(position = 3)
    private List<GameModel> propositions;
}
