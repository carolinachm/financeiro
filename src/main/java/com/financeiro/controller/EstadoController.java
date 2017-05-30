package com.financeiro.controller;

import com.financeiro.model.Entidade;
import com.financeiro.model.Estado;
import com.financeiro.service.EntidadeService;
import com.financeiro.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by carolina on 26/05/17.
 */
@Controller
@RequestMapping("/estados")
public class EstadoController {

    private static final String INDEX = "estado/CadastrarEstado";
    @Autowired
    private EstadoService estadoService;

    @RequestMapping(value = "/novo")
    public String novo(){
        return INDEX;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public String salvar(@Valid Estado estado, BindingResult result){//objeto BindingResult se torna um parâmetro da ação. Então só é preciso perguntar para ele se existe um erro de validação e se existir

        if (result.hasErrors()){

            // TODO: Mostrar mensagem de erro
            return novo();
        }

        System.out.println("Entidade: " + estado.toString());
        estadoService.salvar(estado);

        return novo();
    }
}
