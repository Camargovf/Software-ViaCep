package com.empresa.biblioteca.api.dto;

import com.empresa.biblioteca.domain.models.ClienteModel;
import com.empresa.biblioteca.domain.models.FuncionarioModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class FuncionarioOutputModel {

    private Long id;
    private String nomeFuncionario;
    private String cargoFuncionario;
    private String matriculaFuncionario;
    private String cep;


    public FuncionarioOutputModel(FuncionarioModel funcionarioModel) {
       this.id = funcionarioModel.getId();
       this.cargoFuncionario = funcionarioModel.getCargoFuncionario();
       this.nomeFuncionario = funcionarioModel.getNomeFuncionario();
    }


    public static Page<FuncionarioOutputModel> convertfuncionario(Page<FuncionarioModel> funcionarioModels){
        return funcionarioModels.map(FuncionarioOutputModel::new);
    }

}
