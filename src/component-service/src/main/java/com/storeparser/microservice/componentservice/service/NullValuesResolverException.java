package com.storeparser.microservice.componentservice.service;

public class NullValuesResolverException extends RuntimeException {

    public NullValuesResolverException() {
        super();
    }

    public NullValuesResolverException(String message) {
        super(message);
    }

    public NullValuesResolverException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullValuesResolverException(Throwable cause) {
        super(cause);
    }

    protected NullValuesResolverException(String message, Throwable cause,
                                          boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
