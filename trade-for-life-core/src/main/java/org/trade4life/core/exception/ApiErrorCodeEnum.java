package org.trade4life.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiErrorCodeEnum {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "The service is experiencing issues"), RESOURCE_NOT_FOUND(
        HttpStatus.NOT_FOUND,
        "Resource not found"), RESOURCE_NOT_FOUND_WITH_ID(HttpStatus.NOT_FOUND, "Resource {0} not found"), CONFLICT(
            HttpStatus.CONFLICT, "Resource {0} already exists"), BAD_REQUEST(HttpStatus.BAD_REQUEST, "Invalid Request. {0}");

    private final HttpStatus status;
    private final String message;

    ApiErrorCodeEnum(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
