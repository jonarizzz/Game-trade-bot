package org.trade4life.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.trade4life.core.web.dto.ErrorResponseDto;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException ex, WebRequest request) {
        ErrorResponseDto errorDto = ErrorResponseDto
            .builder()
            .status(ex.getStatusCode().value())
            .message(ex.getReason())
            .errors(ex.getErrors())
            .timestamp(Instant.now().toString())
            .path(((ServletWebRequest) request).getRequest().getRequestURI())
            .build();

        return handleExceptionInternal(ex, errorDto, new HttpHeaders(), ex.getStatusCode(), request);
    }
}
