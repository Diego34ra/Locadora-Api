package com.projeto.locadoraApi.controller;

import com.projeto.locadoraApi.dtos.mapper.AluguelMapper;
import com.projeto.locadoraApi.dtos.request.AluguelCreateDTO;
import com.projeto.locadoraApi.dtos.request.AluguelDTO;
import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.exception.VeiculoNotFoundException;
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

    private AluguelMapper aluguelMapper;

    @PostMapping
    public void create(@RequestBody AluguelCreateDTO aluguelCreateDTO) throws ClienteNotFoundException, VeiculoNotFoundException {
        aluguelService.create(aluguelCreateDTO);
    }

    @GetMapping
    public List<Aluguel> findAll(){
        return aluguelService.findAll();
    }
}
