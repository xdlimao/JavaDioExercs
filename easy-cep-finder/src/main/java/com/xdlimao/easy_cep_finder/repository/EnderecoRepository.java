package com.xdlimao.easy_cep_finder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xdlimao.easy_cep_finder.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
