package com.projeto.locadoraApi.service;

import com.projeto.locadoraApi.dtos.request.AluguelCreateDTO;
import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.exception.VeiculoNotFoundException;
import com.projeto.locadoraApi.model.Aluguel;
import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.model.Veiculo;
import com.projeto.locadoraApi.repository.AluguelRepository;
import com.projeto.locadoraApi.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeiculoService veiculoService;

    public void create(AluguelCreateDTO aluguelCreateDTO) throws ClienteNotFoundException, VeiculoNotFoundException {
        Cliente cliente = clienteService.verificaSeExiste(aluguelCreateDTO.getCliente_id());
        List<Veiculo> veiculoList = new ArrayList<Veiculo>();
        for(int x = 0; x < aluguelCreateDTO.getVeiculos_id().toArray().length; x ++) {
            veiculoList.add(veiculoService.verificaSeExiste((Long) aluguelCreateDTO.getVeiculos_id().toArray()[x]));
        }

        Aluguel aluguel = new Aluguel();
        aluguel.setId(aluguelCreateDTO.getId());
        aluguel.setCliente(cliente);
        aluguel.setVeiculos(veiculoList);
        aluguel.setValorTotal(aluguelCreateDTO.getValorTotal());

        aluguelRepository.save(aluguel);

    }

    public List<Aluguel> findAll(){
        return aluguelRepository.findAll();
    }
    
}
