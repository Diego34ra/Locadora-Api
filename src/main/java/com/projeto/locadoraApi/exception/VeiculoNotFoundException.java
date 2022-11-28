package com.projeto.locadoraApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VeiculoNotFoundException extends Exception{

    public VeiculoNotFoundException(Long id) {
        super("Pessoa com id " + id + " não encontrada");
    }
}
