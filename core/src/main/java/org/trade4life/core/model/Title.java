package org.trade4life.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Title", description = "Game title")
public class Title {
    @ApiModelProperty(position = 1, example = "The Witcher 3: Wild Hunt")
    private String title;
}
