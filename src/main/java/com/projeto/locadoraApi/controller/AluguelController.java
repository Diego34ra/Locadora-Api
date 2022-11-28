package com.projeto.locadoraApi.controller;

import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.model.Aluguel;
import com.projeto.locadoraApi.service.AluguelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluguel")
@AllArgsConstructor
public class AluguelController {

    @Autowired
    private final AluguelService aluguelService;

    @PostMapping
    public void create(@RequestBody Aluguel aluguel) throws ClienteNotFoundException {
        aluguelService.create(aluguel);
    }

    @GetMapping
    public List<Aluguel> findAll(){
        return aluguelService.findAll();
    }
}
