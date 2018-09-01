package com.elan.cursomc.recources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private Long timestamp;
    private Integer Status;
    private String erro;
    private String message;
    private String path;

    public StandardError(){
    }

    public StandardError(Long timestamp, Integer status, String erro, String message, String path) {
        this.timestamp = timestamp;
        Status = status;
        this.erro = erro;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
