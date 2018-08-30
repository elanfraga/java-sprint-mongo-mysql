package com.elan.cursomc.services.exceptions;

public class AuthorizationException extends RuntimeException{


    public AuthorizationException(String msg){
        super(msg);
    }

    public AuthorizationException(String msg, Throwable couse){
        super(msg, couse);
    }
}
