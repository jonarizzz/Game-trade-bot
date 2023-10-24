package org.trade4life.core.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

public abstract class PaginatedRequestDto {

    @NotEmpty
    @Schema(title = "Page number")
    private Integer page;

    @NotEmpty
    @Schema(title = "Page size")
    private Integer size;

    @NotEmpty
    @Schema(
        title = "Sort order",
        example = "asc",
        allowableValues = {"asc", "desc"})
    private String sortOrder;

}
