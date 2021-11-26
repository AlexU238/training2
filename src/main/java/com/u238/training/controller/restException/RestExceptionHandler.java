package com.u238.training.controller.restException;

import com.u238.training.errorResponse.ServerErrorResponse;
import com.u238.training.errorResponse.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ServerErrorResponse> handleException(ServerException exc){
        ServerErrorResponse error= new ServerErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis()
                );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ServerErrorResponse> handleException(Exception e){
        ServerErrorResponse error= new ServerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
