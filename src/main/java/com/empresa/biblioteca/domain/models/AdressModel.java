package com.empresa.biblioteca.domain.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdressModel {

    @Id
    private Long id;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    private String ibge;

    private String gia;

    private String ddd;

    private String siafi;

    public static String cepTratment(String cep) {
        cep = cep.replace(".", "");
        cep = cep.replace("-", "");
        return cep;
    }
}
