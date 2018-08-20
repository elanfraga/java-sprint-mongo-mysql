package com.elan.cursomc.recources.exceptions;

import com.elan.cursomc.recources.ValidationErro;
import com.elan.cursomc.services.exceptions.DataIntegrityException;
import com.elan.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptioHandler  {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardErro> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        StandardErro err = new StandardErro(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardErro> DataIntegrity(DataIntegrityException e, HttpServletRequest request){

        StandardErro err = new StandardErro(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErro> DataIntegrity(MethodArgumentNotValidException e, HttpServletRequest request){

        ValidationErro err = new ValidationErro(HttpStatus.BAD_REQUEST.value(), "Erro de validaçao", System.currentTimeMillis());

        for (FieldError x : e.getBindingResult().getFieldErrors()){
            err.addErro(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
