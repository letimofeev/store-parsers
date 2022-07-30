package com.storeparser.microservice.componentservice.exceptionhandler;

import com.storeparser.microservice.componentservice.service.graphicscard.NoSuchGraphicsCardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GraphicsCardIncorrectData> handleException(NoSuchGraphicsCardException exception) {
        GraphicsCardIncorrectData data = new GraphicsCardIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
