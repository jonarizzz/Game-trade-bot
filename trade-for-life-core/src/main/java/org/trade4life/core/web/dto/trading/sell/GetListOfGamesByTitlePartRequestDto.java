package org.trade4life.core.web.dto.trading.sell;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.trade4life.core.web.dto.PaginatedRequestDto;

import javax.validation.constraints.NotEmpty;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Get list of games by title part request DTO")
public class GetListOfGamesByTitlePartRequestDto extends PaginatedRequestDto {

    @NotEmpty
    @Schema(
        title = "Title part",
        example = "for speed")
    private String titlePart;

    private Long platformId;

}

