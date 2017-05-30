package com.financeiro.service;

import com.financeiro.model.Entidade;
import com.financeiro.repository.Entidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by carolina on 26/05/17.
 */
@Service
public class EntidadeService {
        @Autowired
        private Entidades entidades;

        public void salvar(Entidade entidade){
            entidades.save(entidade);
        }

       public  List<Entidade> listarTodas(){
            return entidades.findAll();
       }
}
