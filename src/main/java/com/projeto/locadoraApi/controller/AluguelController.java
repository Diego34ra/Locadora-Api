package com.projeto.locadoraApi.controller;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.dtos.request.AluguelCreateDTO;
import com.projeto.locadoraApi.exception.AluguelNotFoundException;
import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.exception.VeiculoNotFoundException;
import com.projeto.locadoraApi.model.Aluguel;
import com.projeto.locadoraApi.service.AluguelService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("locadora/aluguel")
@AllArgsConstructor
public class AluguelController {

    @Autowired
    private final AluguelService aluguelService;

    @PostMapping
    @ApiOperation("Cadastrar aluguel")
    public ResponseEntity<MessageResponseDTO> create(@RequestBody @Valid AluguelCreateDTO aluguelCreateDTO) throws ClienteNotFoundException, VeiculoNotFoundException {
        var message = aluguelService.create(aluguelCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PostMapping("{id}")
    @ApiOperation("Registrar data de devolução")
    public ResponseEntity<Aluguel> devolucao(@PathVariable Long id) throws AluguelNotFoundException {
        Aluguel aluguel = aluguelService.checarSaida(id);
        return ResponseEntity.ok().body(aluguel);
    }

    @GetMapping
    @ApiOperation("Buscar todos alugueis")
    public ResponseEntity<List<Aluguel>> findAll(){
        var aluguelList = aluguelService.findAll();
        return ResponseEntity.ok().body(aluguelList);
    }

    @GetMapping("{id}")
    @ApiOperation("Buscar um aluguel")
    public ResponseEntity<Aluguel> findById(@PathVariable Long id) throws AluguelNotFoundException {
        var aluguel = aluguelService.findById(id);
        return ResponseEntity.ok().body(aluguel);
    }

    @PutMapping("{id}")
    @ApiOperation("Atualizar aluguel")
    public ResponseEntity<MessageResponseDTO> update(@PathVariable Long id, @RequestBody AluguelCreateDTO aluguelCreateDTO) throws AluguelNotFoundException, ClienteNotFoundException, VeiculoNotFoundException {
        var message = aluguelService.update(id,aluguelCreateDTO);
        return ResponseEntity.ok().body(message);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Deletar aluguel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws AluguelNotFoundException {
        aluguelService.delete(id);
    }
}
