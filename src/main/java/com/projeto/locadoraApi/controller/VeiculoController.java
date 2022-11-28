package com.projeto.locadoraApi.controller;

import com.projeto.locadoraApi.model.Veiculo;
import com.projeto.locadoraApi.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("veiculo")
@AllArgsConstructor
public class VeiculoController {

    @Autowired
    private final VeiculoService veiculoService;

    @PostMapping
    public void create(@RequestBody Veiculo veiculo){
        veiculoService.create(veiculo);
    }

}
