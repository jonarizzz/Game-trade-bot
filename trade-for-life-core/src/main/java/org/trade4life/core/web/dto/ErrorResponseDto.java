package org.trade4life.core.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseDto {
    @JsonProperty("status")
    private final int status;
    @JsonProperty("message")
    private final String message;
    @JsonProperty("timestamp")
    private final String timestamp;
    @JsonProperty("path")
    private final String path;
    @JsonProperty("errors")
    private final List<String> errors;

}
