package com.empresa.biblioteca.domain.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="TB_FUNCIONARIO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FuncionarioModel {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeFuncionario;
    private String matriculaFuncionario;
    private String cpf;
    private String cargoFuncionario;
    private String cep;


}
