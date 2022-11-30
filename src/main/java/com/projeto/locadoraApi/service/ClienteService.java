package com.projeto.locadoraApi.service;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public MessageResponseDTO create(Cliente cliente){
        Cliente clienteCreated = clienteRepository.save(cliente);
        return MessageResponseDTO
                .builder()
                .message("Cliente com id " + clienteCreated.getId() + " criado.")
                .build();
    }

    public List<Cliente> findAll(){
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList;
    }
    public Cliente findById(Long id) throws ClienteNotFoundException {
        Cliente cliente = verificaSeExiste(id);
        return cliente;
    }

    public void delete(Long id) throws ClienteNotFoundException {
        clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        clienteRepository.deleteById(id);
    }

    public MessageResponseDTO update(Long id, Cliente clienteUpdate) throws ClienteNotFoundException {
        Cliente cliente = verificaSeExiste(id);

        cliente.setCpf(clienteUpdate.getCpf());
        cliente.setNome(clienteUpdate.getNome());
        cliente.setEndereco(clienteUpdate.getEndereco());
        cliente.setCidade(clienteUpdate.getCidade());

        clienteRepository.save(cliente);

        return MessageResponseDTO
                .builder()
                .message("Cliente com id " + id +  " atualizado.")
                .build();
    }




    public Cliente verificaSeExiste(Long id) throws ClienteNotFoundException{
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        return cliente;
    }

}
