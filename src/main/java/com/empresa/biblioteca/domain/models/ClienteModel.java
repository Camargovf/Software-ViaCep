package com.empresa.biblioteca.domain.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="TB_CLIENTE")
public class ClienteModel {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeCliente;
    private String enderecoCliente;
    private String cep;
    private String cpf;
    private String email;


}

