package com.projeto.locadoraApi.dtos.mapper;

import com.projeto.locadoraApi.dtos.request.ClienteCreateDTO;
import com.projeto.locadoraApi.dtos.request.ClienteDTO;
import com.projeto.locadoraApi.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Cliente toClienteCreate(ClienteCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Cliente.class);
    }

    public ClienteDTO toClienteDTO (Cliente cliente) {
        return MODEL_MAPPER.map(cliente,ClienteDTO.class);
    }

    public List<ClienteDTO> toClienteDTOList(List<Cliente> pessoaList) {
        return pessoaList.stream().map(this::toClienteDTO).collect(Collectors.toList());
    }
}
