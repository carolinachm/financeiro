package com.financeiro.service;

import com.financeiro.model.Titulo;
import com.financeiro.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by carolina on 27/05/17.
 */
@Service
public class TituloService {
    @Autowired
    private Titulos titulos;

    public void salvar(Titulo titulo){
        titulos.save(titulo);
    }
}
