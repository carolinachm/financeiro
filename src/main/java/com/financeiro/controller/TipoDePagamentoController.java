package com.financeiro.controller;

import com.financeiro.model.TipoDePagamento;
import com.financeiro.service.TipoDePagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by carolina on 27/05/17.
 */
@Controller
@RequestMapping("/tiposdepagamentos")
public class TipoDePagamentoController {

    private static final String INDEX = "tipodepagamento/CadastrarTipoDePagamento";
    @Autowired
    private TipoDePagamentoService tipoDePagamentoService;

    @RequestMapping(value = "/novo")
    public String novo(TipoDePagamento tipoDePagamento){
        return INDEX;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public String salvar(@Valid TipoDePagamento tipoDePagamento, BindingResult result){//objeto BindingResult se torna um parâmetro da ação. Então só é preciso perguntar para ele se existe um erro de validação e se existir

        if (result.hasErrors()){
            // TODO: Mostrar mensagem de erro
            return novo(tipoDePagamento);
        }

        System.out.println("Tipo de Pagamento: " + tipoDePagamento.toString());
        tipoDePagamentoService.salvar(tipoDePagamento);

        return "redirect:/tiposdepagamentos/novo";

    }
}
