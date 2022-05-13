package com.empresa.biblioteca.api.dto;

import com.empresa.biblioteca.domain.models.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class ClienteOutputModel {

    private long id;

    private String nomeCliente;
    private String enderecoCliente;
    private String cep;
    private String email;


    public ClienteOutputModel(ClienteModel clienteModel) {
        this.id = clienteModel.getId();
        this.cep = clienteModel.getCep();
        this.enderecoCliente = clienteModel.getEnderecoCliente();
        this.nomeCliente = clienteModel.getNomeCliente();
        this.email = clienteModel.getEmail();

    }

    public static Page<ClienteOutputModel> convertcliente(Page<ClienteModel> clienteModels) {
        return clienteModels.map(ClienteOutputModel::new);
    }


}
