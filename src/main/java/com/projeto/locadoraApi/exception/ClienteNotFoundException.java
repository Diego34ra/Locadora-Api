package com.projeto.locadoraApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception{
    public ClienteNotFoundException(String id) {
        super("Cliente não encontrado");
    }
}
