package com.financeiro.repository;

import com.financeiro.model.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by carolina on 26/05/17.
 */
@Repository
public interface Entidades extends JpaRepository<Entidade, Long> {

    List<Entidade> findByNomeContainingIgnoreCase(String nome);

    @Query("select e from Entidade e where nome like %?1% or ?1 is null")
    List<Entidade> porNome(String nome);
}
