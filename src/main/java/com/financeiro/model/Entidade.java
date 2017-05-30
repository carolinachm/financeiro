package com.financeiro.model;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carolina on 26/05/17.
 */
@Entity
@Table(name = "tb_entidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entidade{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long codigo;

        @NotBlank
        @Column(length = 60)
        private String nome;

        @NotBlank
        @Column(length = 20, name = "cpf_ou_cnpj")
        private String cpfOuCnpj;

        @NotBlank
        @Column(length = 20)
        private String telefone;

        @Email
        @Column(length = 100, name = "e_mail")
        private String email;

        @OneToMany(mappedBy = "entidade", orphanRemoval = true) // orphanRemoval - Não pode ter títulos sem entidade
        private List<Titulo> titulos = new ArrayList<>();

        @Embedded
        private Endereco endereco = new Endereco();
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "estado_id")
        private Estado estado;
}
