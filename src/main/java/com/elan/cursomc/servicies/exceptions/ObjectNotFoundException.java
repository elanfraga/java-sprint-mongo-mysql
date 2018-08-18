package com.elan.cursomc.servicies.exceptions;

public class ObjectNotFoundException extends RuntimeException{


    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable couse){
        super(msg, couse);
    }
}
