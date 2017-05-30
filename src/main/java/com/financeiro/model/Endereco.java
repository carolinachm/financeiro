package com.financeiro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * Created by carolina on 26/05/17.
 */
@Embeddable
public class Endereco{

        @Getter
        @Setter
        private String cep;// = null;
        @Getter@Setter
        private String logradouro, bairro, cidade, numero, complemento;
}
