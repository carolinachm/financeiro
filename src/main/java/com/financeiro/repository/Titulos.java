package com.financeiro.repository;

import com.financeiro.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by carolina on 27/05/17.
 */
@Repository
public interface Titulos extends JpaRepository<Titulo, Long>{

}
