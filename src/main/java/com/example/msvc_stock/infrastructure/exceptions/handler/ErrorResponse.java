package com.example.msvc_stock.infrastructure.exceptions.handler;

import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ErrorResponse {
    private final String message;
    private final String details;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ErrorResponse(String message, String details, HttpStatus httpStatus) {
        this.message = message;
        this.details = details;
        this.httpStatus = httpStatus;
        this.timestamp = ZonedDateTime.now(ZoneId.of("America/Bogota"));
    }


    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}
