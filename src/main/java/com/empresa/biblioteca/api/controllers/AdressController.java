package com.empresa.biblioteca.api.controllers;


import com.empresa.biblioteca.domain.models.AdressModel;
import com.empresa.biblioteca.domain.repository.FuncionarioRepository;
import com.empresa.biblioteca.domain.services.AdressService;
import com.empresa.biblioteca.domain.services.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "API REST ViaCEP Consumo")
@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    AdressService adressService;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    FuncionarioService funcionarioService;



    @ApiOperation(value = "Retorna cep ViaCEP")
    @GetMapping("/{cep}")
    public ResponseEntity<AdressModel> getAdressByCEP(@PathVariable String cep) {
        try {
            AdressModel adressSearched = adressService.getAdressByCEP(cep);
            return ResponseEntity.ok().body(adressSearched);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/endereco")
    public List<Object> consultas(){
        return funcionarioRepository.listarconsultas();
    }



}
