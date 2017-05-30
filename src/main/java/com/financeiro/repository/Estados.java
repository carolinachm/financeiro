package com.financeiro.repository;

import com.financeiro.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by carolina on 26/05/17.
 */
@Repository
public interface Estados extends JpaRepository<Estado, Long>{
}
