package org.trade4life.core.service.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.trade4life.core.model.Platform;
import org.trade4life.core.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "UserResponse", description = "Users search result")
public class UserResponse {
    @ApiModelProperty(position = 1, allowableValues = "PSN, ESHOP", example = "PSN")
    private Platform platform;
    @ApiModelProperty(position = 2, example = "1")
    private Integer page;
    @ApiModelProperty(position = 3, example = "3")
    private Integer size;
    @ApiModelProperty(position = 4)
    private List<User> users;
}
