package com.storeparser.microservice.componentservice.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchGraphicsCardException extends RuntimeException {

    public NoSuchGraphicsCardException() {
        super();
    }

    public NoSuchGraphicsCardException(String message) {
        super(message);
    }

    public NoSuchGraphicsCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchGraphicsCardException(Throwable cause) {
        super(cause);
    }
}
