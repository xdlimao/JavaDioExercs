package com.xdlimao.easy_cep_finder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdlimao.easy_cep_finder.model.Endereco;
import com.xdlimao.easy_cep_finder.model.Pessoa;
import com.xdlimao.easy_cep_finder.repository.EnderecoRepository;
import com.xdlimao.easy_cep_finder.repository.PessoaRepository;

@Service
public class PessoaEnderecoService {
	
	@Autowired
	private PessoaRepository _pessoaRepository;
	@Autowired 
	private EnderecoRepository _enderecoRepository;
	@Autowired
	private ViaCepService _viaCepService;
	
	public List<Pessoa> getAll(){
		List<Pessoa> pessoas = _pessoaRepository.findAll();
		return pessoas;
	}
	public Pessoa getById(long id) {
		Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
		return pessoa.get();
	}
	
	public Pessoa createAndUpdate(Pessoa p) {
		String cep = p.getEndereco().getCep();
		Endereco endereco = _enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = _viaCepService.consultarCep(cep);
			_enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		p.setEndereco(endereco);
		return _pessoaRepository.save(p);
	}
	
	public void deleteById(Long id) {
		_pessoaRepository.deleteById(id);
	}
}
