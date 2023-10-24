package org.trade4life.core.web.dto.trading.explore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.trade4life.core.web.dto.PaginatedRequestDto;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Get list of games that have offers request DTO")
public class GetListOfGamesThatHaveOffersRequestDto extends PaginatedRequestDto {

    @NotEmpty
    @Schema(
        title = "User ID",
        example = "1")
    private Long userId;

}
