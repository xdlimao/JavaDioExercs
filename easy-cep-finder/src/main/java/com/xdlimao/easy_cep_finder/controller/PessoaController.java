package com.xdlimao.easy_cep_finder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xdlimao.easy_cep_finder.model.Pessoa;
import com.xdlimao.easy_cep_finder.service.PessoaEnderecoService;

@RestController
public class PessoaController {
	@Autowired
	private PessoaEnderecoService _pessoaEnderecoService;
	@GetMapping
	public ResponseEntity<Iterable<Pessoa>> buscarTodos() {
		return ResponseEntity.ok(_pessoaEnderecoService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(_pessoaEnderecoService.getById(id));
	}

	@PostMapping
	public ResponseEntity<Pessoa> inserir(@RequestBody Pessoa p) {
		_pessoaEnderecoService.createAndUpdate(p);
		return ResponseEntity.ok(p);
	}

	@PutMapping("")
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa p) {
		_pessoaEnderecoService.createAndUpdate(p);
		return ResponseEntity.ok(p);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		_pessoaEnderecoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
