package com.elan.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{


    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable couse){
        super(msg, couse);
    }
}
