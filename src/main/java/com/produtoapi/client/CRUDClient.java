package com.produtoapi.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.produtoapi.model.Produto;

public class CRUDClient {
	private static final String BASE_URL = "http://localhost:8080/produtos";
	private RestTemplate restTemplate;

	public CRUDClient() {
		this.restTemplate = new RestTemplate();
	}

	public void listarTodos() {
		ResponseEntity<Produto[]> response = restTemplate.getForEntity(BASE_URL, Produto[].class);
		List<Produto> produtos = Arrays.asList(response.getBody());
		produtos.forEach(p -> {
			System.out.printf("ID: %d | Nome: %s | Quantidade: %d | Preço: %.2f | Descrição: %s%n", p.getID(),
					p.getNome(), p.getQuantidade(), p.getPreco(), p.getDescricao());
		});
	}

	public Produto salvar(Produto p) {
		HttpEntity<Produto> request = new HttpEntity<>(p);
		return restTemplate.postForObject(BASE_URL, request, Produto.class);
	}

	public void deletar(long id) {
		restTemplate.delete(BASE_URL + "/" + id);
	}

	public Produto atualizar(Long id, Produto p) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Produto> request = new HttpEntity<>(p, headers);
		ResponseEntity<Produto> response = restTemplate.exchange(BASE_URL + "/" + id, HttpMethod.PUT, request,
				Produto.class);
		return response.getBody();
	}

	public Produto getById(long id) {
		ResponseEntity<Produto> response = restTemplate.getForEntity(BASE_URL + "/" + id, Produto.class);
		return response.getBody();
	}

	public static void main(String[] args) {
		CRUDClient client = new CRUDClient();

		client.listarTodos();

		client.deletar(159);
	}

}
