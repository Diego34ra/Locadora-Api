package com.projeto.locadoraApi.dtos.mapper;

import com.projeto.locadoraApi.dtos.request.AluguelCreateDTO;
import com.projeto.locadoraApi.dtos.request.AluguelDTO;
import com.projeto.locadoraApi.dtos.request.ClienteDTO;
import com.projeto.locadoraApi.model.Aluguel;
import com.projeto.locadoraApi.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AluguelMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Aluguel toAluguelCreate(AluguelCreateDTO aluguelDTO){
        return MODEL_MAPPER.map(aluguelDTO, Aluguel.class);
    }

    public AluguelDTO toAluguelDTO(Aluguel aluguel){
        return MODEL_MAPPER.map(aluguel,AluguelDTO.class);
    }

    public List<AluguelDTO> toAluguelDTOList(List<Aluguel> aluguelList) {
        return aluguelList.stream().map(this::toAluguelDTO).collect(Collectors.toList());
    }
}
