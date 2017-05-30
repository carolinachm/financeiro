package com.financeiro.service;

import com.financeiro.model.Estado;
import com.financeiro.repository.Estados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by carolina on 26/05/17.
 */
@Service
public class EstadoService {
    @Autowired
    private Estados estados;

    public void salvar(Estado estado){
        estados.save(estado);
    }
    public List<Estado> listarTodos(){
        return estados.findAll();
    }
}
