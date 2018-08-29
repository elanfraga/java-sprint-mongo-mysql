package com.elan.cursomc.services.exceptions;

public class AutorizationException extends RuntimeException{


    public AutorizationException(String msg){
        super(msg);
    }

    public AutorizationException(String msg, Throwable couse){
        super(msg, couse);
    }
}
