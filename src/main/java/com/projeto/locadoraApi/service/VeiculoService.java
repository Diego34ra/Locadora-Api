package com.projeto.locadoraApi.service;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.exception.VeiculoNotFoundException;
import com.projeto.locadoraApi.model.Veiculo;
import com.projeto.locadoraApi.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VeiculoService {

    @Autowired
    private final VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll(){
        List<Veiculo> veiculoList = veiculoRepository.findAll();
        return veiculoList;
    }

    public Veiculo findById(Long id) throws VeiculoNotFoundException {
        Veiculo veiculo = verificaSeExiste(id);
        return  veiculo;
    }

    public MessageResponseDTO create(Veiculo veiculo){
        Veiculo veiculocreated = veiculoRepository.save(veiculo);

        return MessageResponseDTO
                .builder()
                .message("Veiculo criado com ID " + veiculocreated.getCodigo())
                .build();
    }

    public MessageResponseDTO update(Long id, Veiculo veiculoUpdate) throws VeiculoNotFoundException {
        Veiculo veiculo = verificaSeExiste(id);

        veiculo.setVeiculoTipo(veiculoUpdate.getVeiculoTipo());
        veiculo.setModelo(veiculoUpdate.getModelo());
        veiculo.setAno(veiculoUpdate.getAno());
        veiculo.setCor(veiculoUpdate.getCor());
        veiculo.setPlaca(veiculoUpdate.getPlaca());
        veiculo.setValorDiaria(veiculoUpdate.getValorDiaria());

        veiculoRepository.save(veiculo);
        return MessageResponseDTO
                .builder()
                .message("Veículo com código " + id + " atualizado")
                .build();
    }


    public void delete(Long id) throws VeiculoNotFoundException {
        veiculoRepository.findById(id)
                .orElseThrow(()-> new VeiculoNotFoundException(id));
        veiculoRepository.deleteById(id);
    }

    public Veiculo verificaSeExiste(Long id) throws VeiculoNotFoundException {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new VeiculoNotFoundException(id));
        return veiculo;
    }
}
