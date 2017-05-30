package com.financeiro.controller;

import com.financeiro.model.Entidade;
import com.financeiro.model.Estado;
import com.financeiro.repository.Entidades;
import com.financeiro.service.EntidadeService;
import com.financeiro.service.EstadoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by carolina on 26/05/17.
 */
@Controller
@RequestMapping("/entidades")
public class EntidadeController {

    private static final String INDEX = "entidade/CadastrarEntidade";
    @Autowired
    private EntidadeService entidadeService;
    @Autowired
    private Entidades entidades;
    @Autowired
    private EstadoService estadoService;



    @RequestMapping(value = "/novo")
    public ModelAndView novo(Entidade entidade){
        List<Estado> listarTodos = estadoService.listarTodos();

        ModelAndView mv = new ModelAndView(INDEX);
        mv.addObject("estados", estadoService.listarTodos());
        return mv;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Entidade entidade, BindingResult result){//objeto BindingResult se torna um parâmetro da ação. Então só é preciso perguntar para ele se existe um erro de validação e se existir

        if (result.hasErrors()){
            // TODO: Mostrar mensagem de erro
            return novo(entidade);
        }

        System.out.println("Entidade: " + entidade.toString());
        entidadeService.salvar(entidade);

        return new ModelAndView("redirect:/entidades/novo");

    }
    @RequestMapping
    public ModelAndView pesquisar(Entidade entidade){
        ModelAndView mv = new ModelAndView("entidade/PesquisarEntidade");
        mv.addObject("entidades", entidades.porNome(entidade.getNome()));
        return mv;
    }
    @RequestMapping("/{codigo}")
    public ModelAndView editar(@PathVariable("codigo") Entidade entidade){
        ModelAndView mv = new ModelAndView(INDEX);
        mv.addObject(entidade);
        return mv;
    }
}
