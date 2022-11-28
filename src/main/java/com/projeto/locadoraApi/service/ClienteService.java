package com.projeto.locadoraApi.service;

import com.projeto.locadoraApi.dtos.mapper.ClienteMapper;
import com.projeto.locadoraApi.dtos.request.ClienteCreateDTO;
import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public Cliente verificaSeExiste(Long id) throws ClienteNotFoundException{
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        return cliente;
    }

    public void create(ClienteCreateDTO createDTO){
        Cliente cliente = clienteMapper.toClienteCreate(createDTO);
        clienteRepository.save(cliente);
    }

}
