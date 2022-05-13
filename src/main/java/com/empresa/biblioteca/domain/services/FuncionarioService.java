package com.empresa.biblioteca.domain.services;

import com.empresa.biblioteca.api.dto.FuncionarioInputModel;
import com.empresa.biblioteca.api.dto.FuncionarioOutputModel;
import com.empresa.biblioteca.api.exceptionhandler.EmptyRecurseException;
import com.empresa.biblioteca.domain.models.FuncionarioModel;
import com.empresa.biblioteca.domain.repository.FuncionarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ModelMapper modelMapper;


    public FuncionarioModel buscarFuncionarioPeloId(Long id) {
        Optional<FuncionarioModel> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isEmpty()) {
            throw new EmptyRecurseException("Funcionário não encontrado!");
        }
        return funcionario.get();
    }

    public ResponseEntity<FuncionarioModel> salvarFuncionarioService(FuncionarioInputModel funcionarioInputModel) {
        FuncionarioModel funcionarioModel = toEntity(funcionarioInputModel);
        funcionarioModel = funcionarioRepository.save(funcionarioModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(funcionarioModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(funcionarioModel);
    }


    public ResponseEntity<FuncionarioModel> atualizarFuncionarioService(Long id, FuncionarioInputModel
            funcionarioInputModel) {
        FuncionarioModel funcionarioModel = buscarFuncionarioPeloId(id);
        funcionarioModel.setId(id);
        funcionarioModel.setNomeFuncionario(funcionarioInputModel.getNomeFuncionario());
        funcionarioModel.setCargoFuncionario(funcionarioInputModel.getCargoFuncionario());
        funcionarioModel.setMatriculaFuncionario(funcionarioInputModel.getMatriculaFuncionario());
        funcionarioModel.setCpf(funcionarioInputModel.getCpfFuncionario());
        funcionarioRepository.save(funcionarioModel);

        return ResponseEntity.ok(funcionarioModel);
    }


    public ResponseEntity<FuncionarioModel> excluirFuncionarioService(Long id) {
        FuncionarioModel funcionarioModel = buscarFuncionarioPeloId(id);
        funcionarioRepository.deleteById(funcionarioModel.getId());
        return ResponseEntity.noContent().build();
    }


    private FuncionarioModel toEntity(FuncionarioInputModel funcionarioInputModel) {
        return modelMapper.map(funcionarioInputModel, FuncionarioModel.class);
    }



}


