package com.projeto.locadoraApi.controller;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.dtos.mapper.ClienteMapper;
import com.projeto.locadoraApi.dtos.request.ClienteCreateDTO;
import com.projeto.locadoraApi.dtos.request.ClienteDTO;
import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cliente")
@AllArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

    @PostMapping
    public ResponseEntity<MessageResponseDTO> create(@RequestBody @Valid ClienteCreateDTO createDTO){
        var cliente = clienteMapper.toClienteCreate(createDTO);
        var message = clienteService.create(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        var clienteList = clienteService.findAll();
        var clienteListDTO = clienteMapper.toClienteDTOList(clienteList);
        return ResponseEntity.ok().body(clienteListDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) throws ClienteNotFoundException {
        var cliente = clienteService.findById(id);
        var clienteDTO = clienteMapper.toClienteDTO(cliente);
        return ResponseEntity.ok().body(clienteDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<MessageResponseDTO> update(@PathVariable Long id,
                                                     @RequestBody ClienteCreateDTO clienteCreateDTO) throws ClienteNotFoundException {
        var clienteUpdate = clienteMapper.toClienteCreate(clienteCreateDTO);
        var message = clienteService.update(id,clienteUpdate);
        return ResponseEntity.ok().body(message);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ClienteNotFoundException {
        clienteService.delete(id);
    }
}
