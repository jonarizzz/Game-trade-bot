package org.trade4life.core.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ApiException extends ResponseStatusException {

    private final List<String> errors;

    public ApiException(ApiErrorCodeEnum error) {
        this(error, null, (Object) null);
    }

    public ApiException(ApiErrorCodeEnum error, Object... params) {
        this(error, null, params);
    }

    public ApiException(ApiErrorCodeEnum error, List<String> errors, Object... params) {
        super(error.getStatus(), MessageFormat.format(error.getMessage(), params));
        this.errors = errors;
    }

    public ApiException(HttpStatus status) {
        super(status);
        this.errors = null;
    }

    public ApiException(HttpStatus status, String reason) {
        super(status, reason);
        this.errors = null;
    }

    public ApiException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
        this.errors = null;
    }

    public ApiException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
        this.errors = null;
    }
}
