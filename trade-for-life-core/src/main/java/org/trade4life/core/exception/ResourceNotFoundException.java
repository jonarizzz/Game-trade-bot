package org.trade4life.core.exception;

public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException() {
        this("");
    }

    public ResourceNotFoundException(String resourceIdentifier) {
        super(ApiErrorCodeEnum.RESOURCE_NOT_FOUND_WITH_ID, resourceIdentifier);
    }

}
