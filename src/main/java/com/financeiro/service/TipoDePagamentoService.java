package com.financeiro.service;

import com.financeiro.model.TipoDePagamento;
import com.financeiro.repository.TipoDePagamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by carolina on 27/05/17.
 */
@Service
public class TipoDePagamentoService{
    @Autowired
    private TipoDePagamentos tipoDePagamentos;

    public void salvar(TipoDePagamento tipoDePagamento){
        tipoDePagamentos.save(tipoDePagamento);
    }
}
