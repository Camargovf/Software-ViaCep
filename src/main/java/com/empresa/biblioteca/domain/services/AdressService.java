package com.empresa.biblioteca.domain.services;

import com.empresa.biblioteca.domain.models.AdressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdressService {

    @Autowired
    private RestTemplate http;
    private String URL_API_CEP = "https://viacep.com.br/ws/";

    public AdressModel getAdressByCEP(String cep) {
        try {

            AdressModel searchedAdress = http.getForObject(this.getURICEPAPI(cep), AdressModel.class);
            return searchedAdress;
        } catch (RuntimeException e) {
            throw new IllegalStateException("Houve um erro ao tentar recuperar o endereço pelo CEP: " + e.getMessage());
        }
    }

    private String getURICEPAPI(String cep) {
        cep = AdressModel.cepTratment(cep);
        return this.URL_API_CEP + cep + "/json/";
    }

}
