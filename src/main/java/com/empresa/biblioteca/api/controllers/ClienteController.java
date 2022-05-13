package com.empresa.biblioteca.api.controllers;


import com.empresa.biblioteca.api.dto.ClienteInputModel;
import com.empresa.biblioteca.api.dto.ClienteOutputModel;
import com.empresa.biblioteca.domain.models.ClienteModel;
import com.empresa.biblioteca.domain.repository.ClienteRepository;
import com.empresa.biblioteca.domain.services.ClienteService;
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

@Api(value = "API REST Clientes")
@RestController("DtoClienteController")
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteService clienteService;


    @ApiOperation(value = "Retorna clientes por clientes?pagina=1&qtd=2")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClienteOutputModel> listarclientepagina(@RequestParam int pagina,
                                                        @RequestParam int qtd) {

        Pageable paginacao = PageRequest.of(pagina, qtd);
        Page<ClienteModel> clienteModels = clienteRepository.findAll(paginacao);
        return ClienteOutputModel.convertcliente(clienteModels);

    }

    @ApiOperation(value = "Lista um id relacionado a um cliente")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteModel buscarclienteid(@PathVariable Long id) {
        return clienteService.buscarClientePeloId(id);
    }

    @PostMapping
    public ResponseEntity<ClienteModel> salvarClienteService(@Valid @RequestBody ClienteInputModel clienteInputModel) {
        return clienteService.salvarClienteService(clienteInputModel);
    }

    @ApiOperation(value = "Atualiza um id relacionado a um cliente")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarClienteService(@PathVariable Long id, @Valid @RequestBody ClienteInputModel clienteInputModel) {
        return clienteService.atualizarClienteService(id, clienteInputModel);
    }

    @ApiOperation(value = "Exclui um id relacionado a um cliente")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<ClienteModel> excluirClienteService(@PathVariable Long id) {
        return clienteService.excluirClienteService(id);
    }

}
