package com.elan.cursomc.recources;

import com.elan.cursomc.recources.exceptions.FieldMessage;
import com.elan.cursomc.recources.exceptions.StandardError;

import java.util.ArrayList;
import java.util.List;

public class ValidationErro  extends StandardError {

    List<FieldMessage> erros = new ArrayList<>();


    public ValidationErro(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addErro(String fieldName, String messagem) {
        erros.add(new FieldMessage(fieldName, messagem));
    }
}
