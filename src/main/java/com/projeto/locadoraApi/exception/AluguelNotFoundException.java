package com.projeto.locadoraApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AluguelNotFoundException extends Exception{
    public AluguelNotFoundException(Long id) {
        super("Aluguel não encontrado");
    }
}
