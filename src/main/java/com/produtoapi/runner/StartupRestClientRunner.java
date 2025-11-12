package com.produtoapi.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.produtoapi.model.Produto;

@Component
public class StartupRestClientRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("🚀 Servidor iniciado!");

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/produtos";

		try {
			Produto[] produtosArray = restTemplate.getForObject(url, Produto[].class);

			if (produtosArray != null && produtosArray.length > 0) {
				List<Produto> produtos = Arrays.asList(produtosArray);
				produtos.forEach(
						p -> System.out.printf("ID: %d | Nome: %s | Quantidade: %d | Preço: %.2f | Descrição: %s%n",
								p.getID(), p.getNome(), p.getQuantidade(), p.getPreco(), p.getDescricao()));
			} else {
				System.out.println("Nenhum produto encontrado no endpoint.");
			}

		} catch (Exception e) {
			System.out.println("❌ Erro ao conectar com o servidor: " + e.getMessage());
		}
	}
}
