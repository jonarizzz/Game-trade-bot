package org.trade4life.core.exception;

import java.util.List;

public class InternalServerException extends ApiException {

    public InternalServerException() {
        this(null, "");
    }

    public InternalServerException(Object... params) {
        this(null, params);
    }

    public InternalServerException(List<String> errors) {
        this(errors, "");
    }

    public InternalServerException(List<String> errors, Object... params) {
        super(ApiErrorCodeEnum.INTERNAL_SERVER_ERROR, errors, params);
    }

}
