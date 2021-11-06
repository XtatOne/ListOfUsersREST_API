package com.listofusers.sring.rest.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectUser> handleException(NoUserException exception) {

        IncorrectUser incorrectUser = new IncorrectUser(exception.getMessage());

        return new ResponseEntity<>(incorrectUser, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<IncorrectUser> handleException(Exception exception) {

        IncorrectUser incorrectUser = new IncorrectUser(exception.getMessage());

        return new ResponseEntity<>(incorrectUser, HttpStatus.BAD_REQUEST);

    }

}
