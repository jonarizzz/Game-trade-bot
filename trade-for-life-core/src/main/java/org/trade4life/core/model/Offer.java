package org.trade4life.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id", "gameId", "telegramUserId" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Offer", description = "Offer information")
public class Offer {
    @ApiModelProperty(position = 1)
    private String id;
    @ApiModelProperty(position = 2)
    private String gameId;
    @ApiModelProperty(position = 3)
    private String telegramUserId;
    @ApiModelProperty(position = 4, example = "PSN")
    private Platform platform;
    @ApiModelProperty(position = 5, example = "BELARUS")
    private Region region;
    @ApiModelProperty(position = 6, example = "SELL")
    private OfferType type;
    @ApiModelProperty(position = 7, example = "Open for swap. Minsk. Nemiga")
    private String description;
    @ApiModelProperty(position = 8, example = "75")
    private Integer price;
    @ApiModelProperty(position = 9, example = "PUBLISHED")
    @JsonIgnore
    private OfferStatus status;
}
