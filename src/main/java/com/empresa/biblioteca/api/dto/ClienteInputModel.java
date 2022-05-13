package com.empresa.biblioteca.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClienteInputModel {

    private long id;

    @NotBlank
    @Size(min = 2, max = 70)
    @Pattern(regexp = "^[A-Z]+(.)*", message = "A palavra deve iniciar com letra maiuscula")
    private String nomeCliente;

    @NotBlank
    @Size(min = 5, max = 100)
    @Pattern(regexp = "^[A-Z]+(.)*", message = "A palavra deve iniciar com letra maiuscula")
    private String enderecoCliente;

    @NotBlank
    @Size(min = 8, max = 10)
    @Pattern(regexp = "[0-9]*")
    private String cep;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;


}
