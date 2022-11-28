package com.projeto.locadoraApi.service;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.dtos.mapper.ClienteMapper;
import com.projeto.locadoraApi.dtos.mapper.VeiculoMapper;
import com.projeto.locadoraApi.dtos.request.VeiculoCreateDTO;
import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.model.Veiculo;
import com.projeto.locadoraApi.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VeiculoService {

    @Autowired
    private final VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoMapper veiculoMapper;

    public MessageResponseDTO create(Veiculo veiculo){
        Veiculo veiculocreated = veiculoRepository.save(veiculo);

        return MessageResponseDTO
                .builder()
                .message("Veiculo criado com ID " + veiculocreated.getCodigo())
                .build();
    }

//    public Cliente verificaSeExiste(Long id) throws ClienteNotFoundException {
//        Cliente cliente = clienteRepository.findById(id)
//                .orElseThrow(() -> new ClienteNotFoundException(id));
//        return cliente;
//    }
}
