package org.trade4life.core.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

public abstract class PaginatedResponseDto {

    @NotEmpty
    @Schema(title = "Page number")
    private Integer page;

    @NotEmpty
    @Schema(title = "Page size")
    private Integer size;

    @NotEmpty
    @Schema(title = "Total pages")
    private Integer totalPages;

    @NotEmpty
    @Schema(title = "Total elements")
    private Integer totalElements;

    @NotEmpty
    @Schema(
        title = "Sort order",
        example = "asc",
        allowableValues = {"asc", "desc"})
    private String sortOrder;

}
