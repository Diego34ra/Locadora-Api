package com.projeto.locadoraApi.service;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.dtos.mapper.AluguelMapper;
import com.projeto.locadoraApi.dtos.request.AluguelCreateDTO;
import com.projeto.locadoraApi.exception.AluguelNotFoundException;
import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.exception.VeiculoNotFoundException;
import com.projeto.locadoraApi.model.Aluguel;
import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.model.Veiculo;
import com.projeto.locadoraApi.repository.AluguelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private AluguelMapper aluguelMapper;

    public MessageResponseDTO create(AluguelCreateDTO aluguelCreateDTO) throws ClienteNotFoundException, VeiculoNotFoundException {
        Cliente cliente = clienteService.verificaSeExiste(aluguelCreateDTO.getCliente_id());

        List<Veiculo> veiculoList = new ArrayList<>();
        for(Long id: aluguelCreateDTO.getVeiculos_id()) {
            veiculoList.add(veiculoService.verificaSeExiste(id));
        }

        Aluguel aluguel = aluguelMapper.toAluguelCreate(aluguelCreateDTO);
        aluguel.setCliente(cliente);
        aluguel.setVeiculos(veiculoList);
        aluguel.setDataAluguel(LocalDateTime.now());

        aluguelRepository.save(aluguel);
        return MessageResponseDTO.builder()
                .message("Aluguel com id " + aluguel.getId() + " criado." )
                .build();
    }

    public List<Aluguel> findAll(){
        List<Aluguel> aluguelList = aluguelRepository.findAll();
        return aluguelList;
    }

    public Aluguel findById(Long id) throws AluguelNotFoundException {
        Aluguel aluguel = verificaSeExiste(id);
        return aluguel;
    }

    public MessageResponseDTO update(Long id, AluguelCreateDTO aluguelUpdate)
            throws AluguelNotFoundException,
            ClienteNotFoundException,
            VeiculoNotFoundException {

        Aluguel aluguel = verificaSeExiste(id);

        Cliente cliente = clienteService.verificaSeExiste(aluguelUpdate.getCliente_id());

        List<Veiculo> veiculoList = new ArrayList<>();
        for( Long x: aluguelUpdate.getVeiculos_id()) {
            veiculoList.add(veiculoService.verificaSeExiste(x));
        }

        aluguel.setVeiculos(veiculoList);
        aluguel.setCliente(cliente);
        aluguelRepository.save(aluguel);

        return MessageResponseDTO
                .builder()
                .message("Aluguel com id " + id + " atualizado")
                .build();
    }

    public void delete(Long id) throws AluguelNotFoundException {
        aluguelRepository.findById(id)
                .orElseThrow(() -> new AluguelNotFoundException(id));
        aluguelRepository.deleteById(id);
    }


    public Aluguel verificaSeExiste(Long id) throws AluguelNotFoundException {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new AluguelNotFoundException(id));
        return aluguel;
    }


    public Aluguel checarSaida(Long id) throws AluguelNotFoundException {
        Aluguel aluguel = verificaSeExiste(id);
        aluguel.setDataDevolucao(LocalDateTime.now());
        Double valor = 0.0;
        for(Veiculo veiculo: aluguel.getVeiculos()) {
            valor += AluguelDevolucao.getConta(aluguel,veiculo.getValorDiaria());
        }

        aluguel.setValorTotal(valor);
        aluguelRepository.save(aluguel);
        return aluguel;
    }
    
}
