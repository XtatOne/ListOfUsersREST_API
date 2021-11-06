package com.listofusers.sring.rest.exeptions;

public class NoUserException extends RuntimeException {

    public NoUserException(String message) {
        super(message);
    }
}
