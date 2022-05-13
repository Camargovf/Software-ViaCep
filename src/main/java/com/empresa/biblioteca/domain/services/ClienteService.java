package com.empresa.biblioteca.domain.services;

import com.empresa.biblioteca.api.dto.ClienteInputModel;
import com.empresa.biblioteca.api.dto.ClienteOutputModel;
import com.empresa.biblioteca.api.exceptionhandler.EmptyRecurseException;
import com.empresa.biblioteca.domain.models.ClienteModel;
import com.empresa.biblioteca.domain.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;


    public ClienteModel buscarClientePeloId(Long id) {
        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new EmptyRecurseException("Funcionário não encontrado!");
        }
        return cliente.get();
    }


    public ResponseEntity<ClienteModel> salvarClienteService(ClienteInputModel clienteInputModel) {
        ClienteModel clienteModel = toEntity(clienteInputModel);
        clienteModel = clienteRepository.save(clienteModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(clienteModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(clienteModel);
    }


    public ResponseEntity<ClienteModel> atualizarClienteService(Long id, ClienteInputModel
            clienteInputModel) {
        ClienteModel clienteModel = buscarClientePeloId(id);
        clienteModel.setId(id);
        clienteModel.setNomeCliente(clienteInputModel.getNomeCliente());
        clienteModel.setEnderecoCliente(clienteInputModel.getEnderecoCliente());
        clienteModel.setCep(clienteInputModel.getCep());
        clienteModel.setCpf(clienteInputModel.getCpf());
        clienteModel.setEmail(clienteInputModel.getEmail());

        clienteRepository.save(clienteModel);

        return ResponseEntity.ok(clienteModel);
    }


    public ResponseEntity<ClienteModel> excluirClienteService(Long id) {
        ClienteModel clienteModel = buscarClientePeloId(id);
        clienteRepository.deleteById(clienteModel.getId());
        return ResponseEntity.noContent().build();
    }

    private ClienteModel toEntity(ClienteInputModel clienteInputModel) {
        return modelMapper.map(clienteInputModel, ClienteModel.class);
    }



}