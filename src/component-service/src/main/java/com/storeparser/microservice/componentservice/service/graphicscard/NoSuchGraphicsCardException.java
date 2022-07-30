package com.storeparser.microservice.componentservice.service.graphicscard;

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
