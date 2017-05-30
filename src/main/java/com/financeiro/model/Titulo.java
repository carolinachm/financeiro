package com.financeiro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by carolina on 26/05/17.
 */
@Entity
@Table(name = "tb_titulo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidadeId")
    private Entidade entidade;

    @Column(name = "data_de_emissao")
    private Date dataDeEmissao;

    @Column(name = "data_de_validade")
    private Date dataDeValidade;

    @Column(name = "data_do_pagamento")
    private Date dataDoPagamento;

    private BigDecimal valor;

    @Column(name = "valor_pago")
    private BigDecimal valorPago;

    @Column(name = "valor_original")
    private BigDecimal valorOriginal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoDePagamentoId")
    private TipoDePagamento tipoDePagamento;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

}
