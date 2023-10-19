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
@ApiModel(value = "GameResponse", description = "Games search result")
public class GameResponse {
    @ApiModelProperty(position = 1, example = "1")
    private Integer page;
    @ApiModelProperty(position = 2, example = "3")
    private Integer size;
    @ApiModelProperty(position = 3, example = "5")
    private Integer totalPages;
    @ApiModelProperty(position = 4, example = "7")
    private Long totalGames;
    @ApiModelProperty(position = 5)
    private List<GameModel> games;
}
