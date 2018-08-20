package com.elan.cursomc.services.exceptions;

public class DataIntegrityException extends RuntimeException{


    public DataIntegrityException(String msg){
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable couse){
        super(msg, couse);
    }
}
