package org.trade4life.core.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public abstract class PaginatedResponseDto {

    @Schema(title = "Page number")
    private Integer page;

    @Schema(title = "Page size")
    private Integer size;

    @Schema(title = "Total pages")
    private Integer totalPages;

    @Schema(title = "Total elements")
    private Integer totalElements;

    @Schema(
        title = "Sort order",
        example = "asc",
        allowableValues = { "asc", "desc" })
    private String sortOrder;

}
