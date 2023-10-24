package org.trade4life.core.web.dto.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.trade4life.core.web.dto.PaginatedResponseDto;
import org.trade4life.core.web.dto.trading.OfferDto;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Schema(title = "Get User Offers response DTO")
public class GetUserOffersResponseDto extends PaginatedResponseDto {

    @Schema(title = "User's offers")
    List<OfferDto> offers;

}
