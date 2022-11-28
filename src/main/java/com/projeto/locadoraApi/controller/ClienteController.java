package com.projeto.locadoraApi.controller;

import com.projeto.locadoraApi.dtos.request.ClienteCreateDTO;
import com.projeto.locadoraApi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid ClienteCreateDTO createDTO){
        clienteService.create(createDTO);
    }
}
