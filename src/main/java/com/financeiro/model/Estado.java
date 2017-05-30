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
@Table(name = "tb_estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 60)
    private String sigla;
    @Column(length = 60)
    private String nome;
    @OneToMany(mappedBy = "estado", orphanRemoval = true) // orphanRemoval - Não pode ter títulos sem entidade
    private List<Entidade> entidades = new ArrayList<>();

}
