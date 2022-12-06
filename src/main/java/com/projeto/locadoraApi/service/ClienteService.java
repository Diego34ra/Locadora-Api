package com.projeto.locadoraApi.service;

import com.projeto.locadoraApi.dtos.MessageResponseDTO;
import com.projeto.locadoraApi.exception.ClienteNotFoundException;
import com.projeto.locadoraApi.model.Cliente;
import com.projeto.locadoraApi.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public MessageResponseDTO create(Cliente cliente){
        String uuid = getUUID();
        cliente.setId(uuid);
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
    public Cliente findById(String id) throws ClienteNotFoundException {
        Cliente cliente = verificaSeExiste(id);
        return cliente;
    }

    public void delete(String id) throws ClienteNotFoundException {
        clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        clienteRepository.deleteById(id);
    }

    public MessageResponseDTO update(String id, Cliente clienteUpdate) throws ClienteNotFoundException {
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




    public Cliente verificaSeExiste(String id) throws ClienteNotFoundException{
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        return cliente;
    }

}
