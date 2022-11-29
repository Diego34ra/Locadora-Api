package com.projeto.locadoraApi.controller;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.dtos.mapper.VeiculoMapper;
import com.projeto.locadoraApi.dtos.request.VeiculoCreateDTO;
import com.projeto.locadoraApi.dtos.request.VeiculoDTO;
import com.projeto.locadoraApi.exception.VeiculoNotFoundException;
import com.projeto.locadoraApi.model.Veiculo;
import com.projeto.locadoraApi.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll(){
        List<VeiculoDTO> veiculoList = veiculoService.findAll();
        return ResponseEntity.ok(veiculoList);
    }

    @GetMapping("{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) throws VeiculoNotFoundException {
        Veiculo veiculo = veiculoService.findById(id);
        VeiculoDTO veiculoDTO = veiculoMapper.toVeiculoDTO(veiculo);
        return ResponseEntity.ok(veiculoDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws VeiculoNotFoundException {
        veiculoService.delete(id);
    }

}
