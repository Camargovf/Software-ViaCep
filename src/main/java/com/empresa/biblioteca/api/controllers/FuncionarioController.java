package com.empresa.biblioteca.api.controllers;


import com.empresa.biblioteca.api.dto.FuncionarioInputModel;
import com.empresa.biblioteca.api.dto.FuncionarioOutputModel;
import com.empresa.biblioteca.domain.models.FuncionarioModel;
import com.empresa.biblioteca.domain.repository.FuncionarioRepository;
import com.empresa.biblioteca.domain.services.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "API Rest Funcionários")
@RestController("DtoFuncionarioController")
@RequestMapping("/funcionarios")
public class FuncionarioController {


    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    FuncionarioService funcionarioService;


    @ApiOperation(value = "Retorna clientes por funcionario?pagina=1&qtd=2 ")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<FuncionarioOutputModel> listarfuncionariopagina(@RequestParam int pagina,
                                                                @RequestParam int qtd) {

        Pageable paginacao = PageRequest.of(pagina, qtd);
        Page<FuncionarioModel> funcionarioModels = funcionarioRepository.findAll(paginacao);
        return FuncionarioOutputModel.convertfuncionario(funcionarioModels);

    }


    @ApiOperation(value = "Lista um id relacionado a um funcionário")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioModel buscarfuncionarioid(@PathVariable Long id) {
        return funcionarioService.buscarFuncionarioPeloId(id);
    }


    @ApiOperation(value = "Cria um id relacionado a um funcionário")
    @PostMapping
    public ResponseEntity<FuncionarioModel> salvarFuncionarioService(@Valid @RequestBody FuncionarioInputModel funcionarioInputModel) {
        return funcionarioService.salvarFuncionarioService(funcionarioInputModel);
    }

    @ApiOperation(value = "Atualiza um id relacionado a um funcionário")
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizarFuncionarioService(@PathVariable Long id, @Valid @RequestBody FuncionarioInputModel funcionarioInputModel) {
        return funcionarioService.atualizarFuncionarioService(id, funcionarioInputModel);
    }

    @ApiOperation(value = "Deleta um id relacionado a um funcionárioß")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<FuncionarioModel> excluirFuncionarioService(@PathVariable Long id) {
        return funcionarioService.excluirFuncionarioService(id);
    }

}

