package com.produtoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtoapi.model.Pessoa;
import com.produtoapi.service.PessoaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pessoas")
public class PessoaControler {

	public String formatCpfCnpj(String doc, String type) {
		if (type.equals("Cliente")) {
			return doc.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
		} else {
			return doc.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
		}
	}

	@Autowired
	PessoaService pService;

	@GetMapping
	public List<Pessoa> listarTodos() {
		List<Pessoa> pessoas = pService.listarPessoas();
		for (Pessoa p : pessoas) {
			p.setDoc(formatCpfCnpj(p.getDoc(), p.getType()));
		}
		return pessoas;
	}

	@PostMapping
	public Pessoa salvar(@RequestBody Pessoa p) {
		return pService.salvar(p);
	}

	@PostMapping("/salvarlote")
	public List<Pessoa> salvarLista(@RequestBody List<Pessoa> p) {
		return pService.salvarLote(p);
	}

	@PutMapping("/{id}")
	public Pessoa editar(@PathVariable Long id, @RequestBody Pessoa p) {
		return pService.editar(id, p);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		pService.deletar(id);
	}
}
