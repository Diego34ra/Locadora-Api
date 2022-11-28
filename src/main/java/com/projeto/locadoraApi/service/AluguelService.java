package com.projeto.locadoraApi.service;

import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.model.Aluguel;
import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.model.Veiculo;
import com.projeto.locadoraApi.repository.AluguelRepository;
import com.projeto.locadoraApi.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    public void create(Aluguel aluguel) throws ClienteNotFoundException {
        salvarAluguelcomCliente(aluguel);
        salvarAluguelcomVeiculo(aluguel);
    }

    public List<Aluguel> findAll(){
        return aluguelRepository.findAll();
    }


    private void salvarAluguelcomCliente(Aluguel aluguel) throws ClienteNotFoundException {
        long id = aluguel.getCliente().getId();
        Cliente cliente = clienteService.verificaSeExiste(id);
        aluguel.setCliente(cliente);
        aluguelRepository.save(aluguel);
    }

    private void salvarAluguelcomVeiculo(Aluguel aluguel) throws ClienteNotFoundException {
        List<Veiculo> veiculos = aluguel.getVeiculos();
//        for (int i = 0; i < veiculos.toArray().length; i++){
//
//        }
//        Cliente cliente = clienteService.verificaSeExiste(id);
        aluguel.setVeiculos(veiculos);
        aluguelRepository.save(aluguel);
    }
}
