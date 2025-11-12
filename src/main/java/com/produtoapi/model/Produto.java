package com.produtoapi.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotEmpty(message = "Informe um nome!")
	private String nome;
	private String descricao;
	private int quantidade;
	private Double preco;
	private String status;
	private String imagem;

	public Produto() {

	}

	public void setID(long id) {
		this.id = id;
	}

	public long getID() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

	public void setDescicao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getImagem() {
		return imagem;
	}

	@JsonGetter("precoFormatado")
	public String getPrecoFormatado() {
		if (preco == null)
			return null;
		return String.format("%.2f", preco).replace('.', ',');
	}
}
