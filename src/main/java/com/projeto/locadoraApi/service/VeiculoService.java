package com.projeto.locadoraApi.service;

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

    public void create(Veiculo veiculo){
        veiculoRepository.save(veiculo);
    }

//    public Cliente verificaSeExiste(Long id) throws ClienteNotFoundException {
//        Cliente cliente = clienteRepository.findById(id)
//                .orElseThrow(() -> new ClienteNotFoundException(id));
//        return cliente;
//    }
}
