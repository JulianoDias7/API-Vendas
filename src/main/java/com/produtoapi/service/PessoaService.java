package com.produtoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtoapi.model.Pessoa;
import com.produtoapi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pRepository;

	public List<Pessoa> listarPessoas() {
		return pRepository.findAll();
	}

	public Pessoa salvar(Pessoa p) {
		return pRepository.save(p);
	}

	public List<Pessoa> salvarLote(List<Pessoa> p) {
		return pRepository.saveAll(p);
	}

	public Pessoa editar(Long id, Pessoa p) {
		if (pRepository.existsById(id)) {
			p.setId(id);
			return pRepository.save(p);
		} else {
			throw new RuntimeException("Cadastro não encontrado!");
		}

	}

	public void deletar(long id) {
		pRepository.deleteById(id);
	}

}
