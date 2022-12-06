package com.projeto.locadoraApi.controller;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.dtos.mapper.VeiculoMapper;
import com.projeto.locadoraApi.dtos.request.VeiculoCreateDTO;
import com.projeto.locadoraApi.dtos.request.VeiculoDTO;
import com.projeto.locadoraApi.exception.VeiculoNotFoundException;
import com.projeto.locadoraApi.service.VeiculoService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("locadora/veiculo")
@AllArgsConstructor
public class VeiculoController {

    @Autowired
    private final VeiculoService veiculoService;

    @Autowired
    private VeiculoMapper veiculoMapper;

    @PostMapping
    @ApiOperation("Cadastar veículo")
    public ResponseEntity<MessageResponseDTO> create(@RequestBody @Valid VeiculoCreateDTO createDTO){
        var veiculoCreate = veiculoMapper.toVeiculoCreate(createDTO);
        var veiculo = veiculoService.create(veiculoCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    @GetMapping
    @ApiOperation("Buscar todos veículos")
    public ResponseEntity<List<VeiculoDTO>> findAll(){
        var veiculoList = veiculoService.findAll();
        var veiculoListDTO = veiculoMapper.toveiculoDTOList(veiculoList);
        return ResponseEntity.ok().body(veiculoListDTO);
    }

    @GetMapping("{id}")
    @ApiOperation("Buscar um veículo")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable String id) throws VeiculoNotFoundException {
        var veiculo = veiculoService.findById(id);
        var veiculoDTO = veiculoMapper.toVeiculoDTO(veiculo);
        return ResponseEntity.ok(veiculoDTO);
    }

    @PutMapping("{id}")
    @ApiOperation("Atualizar veículo")
    public ResponseEntity<MessageResponseDTO> update(@PathVariable String id,
                                                     @RequestBody VeiculoCreateDTO veiculoCreateDTO) throws VeiculoNotFoundException {
        var veiculoUpdate = veiculoMapper.toVeiculoCreate(veiculoCreateDTO);
        var message = veiculoService.update(id,veiculoUpdate);
        return ResponseEntity.ok().body(message);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Deletar veículo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) throws VeiculoNotFoundException {
        veiculoService.delete(id);
    }

}
