package com.example.library.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String arg0) {
        super(arg0);
    }

    public ObjectNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
