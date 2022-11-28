package com.projeto.locadoraApi.controller;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.dtos.mapper.VeiculoMapper;
import com.projeto.locadoraApi.dtos.request.VeiculoCreateDTO;
import com.projeto.locadoraApi.model.Veiculo;
import com.projeto.locadoraApi.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("veiculo")
@AllArgsConstructor
public class VeiculoController {

    @Autowired
    private final VeiculoService veiculoService;

    @Autowired
    private VeiculoMapper veiculoMapper;

    @PostMapping
    public ResponseEntity<MessageResponseDTO> create(@RequestBody @Valid VeiculoCreateDTO createDTO){
        var veiculoCreate = veiculoMapper.toVeiculoCreate(createDTO);
        var pessoa = veiculoService.create(veiculoCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

}
