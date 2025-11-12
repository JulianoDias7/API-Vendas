package com.produtoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtoapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
