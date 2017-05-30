package com.financeiro.controller;

import com.financeiro.model.Titulo;
import com.financeiro.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by carolina on 24/05/17.
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {

    private final String INDEX = "titulo/CadastrarTitulo";
    @Autowired
    private TituloService tituloService;

    @RequestMapping(value = "/")
    public String novo(Titulo titulo){
        return INDEX;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public String salvar(@Valid Titulo titulo, BindingResult result){//objeto BindingResult se torna um parâmetro da ação. Então só é preciso perguntar para ele se existe um erro de validação e se existir

        if (result.hasErrors()){
            // TODO: Mostrar mensagem de erro
            return novo(titulo);
        }

        System.out.println("Titulo: " + titulo.toString());
        tituloService.salvar(titulo);

        return "redirect:/titulos/novo";

    }

}