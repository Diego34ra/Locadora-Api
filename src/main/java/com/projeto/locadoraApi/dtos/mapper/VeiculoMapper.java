package com.projeto.locadoraApi.dtos.mapper;

import com.projeto.locadoraApi.dtos.request.VeiculoCreateDTO;
import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Veiculo toVeiculoCreate(VeiculoCreateDTO createDTO){
        return MODEL_MAPPER.map(createDTO, Veiculo.class);
    }
}
