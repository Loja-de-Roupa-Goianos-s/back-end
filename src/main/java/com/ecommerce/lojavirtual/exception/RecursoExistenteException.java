package com.ecommerce.lojavirtual.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RecursoExistenteException extends RuntimeException {

    public RecursoExistenteException(String mensagem) {
        super(mensagem);
    }
}