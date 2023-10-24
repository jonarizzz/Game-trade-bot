package org.trade4life.core.web.dto.trading.sell;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.trade4life.core.web.dto.trading.GameDto;
import org.trade4life.core.web.dto.PaginatedResponseDto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Get list of games by title part response DTO")
public class GetListOfGamesByTitlePartResponseDto extends PaginatedResponseDto {

    @NotEmpty
    @Schema(title = "List of games")
    private List<GameDto> games;

}
