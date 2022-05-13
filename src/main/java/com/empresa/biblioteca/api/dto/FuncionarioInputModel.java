package com.empresa.biblioteca.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class FuncionarioInputModel {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 70)
    @Pattern(regexp = "^[A-Z]+(.)*", message = "A palavra deve iniciar com letra maiuscula")
    private String nomeFuncionario;

    @NotBlank
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0-9]*")
    private String matriculaFuncionario;

    @NotBlank
    @CPF
    @Pattern(regexp = "[0-9]*")
    private String cpfFuncionario;

    @NotBlank
    @Size(min = 2, max = 70)
    @Pattern(regexp = "^[A-Z]+(.)*", message = "A palavra deve iniciar com letra maiuscula")
    private String cargoFuncionario;

    @NotBlank
    @Size(min = 8, max = 10)
    @Pattern(regexp = "[0-9]*")
    private String cep; //74810-220
}
