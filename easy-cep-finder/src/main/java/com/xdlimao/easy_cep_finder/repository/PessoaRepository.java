package com.xdlimao.easy_cep_finder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xdlimao.easy_cep_finder.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
