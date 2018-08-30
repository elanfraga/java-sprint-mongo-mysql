package com.elan.cursomc.services.exceptions;

public class FileException extends RuntimeException{


    public FileException(String msg){
        super(msg);
    }

    public FileException(String msg, Throwable couse){
        super(msg, couse);
    }
}