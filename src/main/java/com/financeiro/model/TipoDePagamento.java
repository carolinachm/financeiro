package com.financeiro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carolina on 26/05/17.
 */
@Entity
@Table(name = "tb_tipodepagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDePagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 150)
    private String descricao;

    @OneToMany(mappedBy = "tipoDePagamento", orphanRemoval = true) // orphanRemoval - Não pode ter títulos sem tipodepagamento
    private List<Titulo> titulos = new ArrayList<>();

}
