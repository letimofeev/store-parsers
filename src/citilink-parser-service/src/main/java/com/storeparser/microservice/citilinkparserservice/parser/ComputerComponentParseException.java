package com.storeparser.microservice.citilinkparserservice.parser;

public class ComputerComponentParseException extends RuntimeException {

    public ComputerComponentParseException() {
        super();
    }

    public ComputerComponentParseException(String message) {
        super(message);
    }

    public ComputerComponentParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComputerComponentParseException(Throwable cause) {
        super(cause);
    }

    protected ComputerComponentParseException(String message, Throwable cause,
                                              boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
