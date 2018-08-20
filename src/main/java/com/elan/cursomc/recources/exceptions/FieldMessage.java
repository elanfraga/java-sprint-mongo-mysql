package com.elan.cursomc.recources.exceptions;

public class FieldMessage {

    private String fieldName;
    private String messagem;

    public FieldMessage() {

    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.messagem = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }
}
