package com.elan.cursomc.recources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    List<FieldMessage> erros = new ArrayList<>();



    public ValidationError(Long timestamp, Integer status, String erro, String message, String path) {
        super(timestamp, status, erro, message, path);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String messagem) {
        erros.add(new FieldMessage(fieldName, messagem));
    }
}
