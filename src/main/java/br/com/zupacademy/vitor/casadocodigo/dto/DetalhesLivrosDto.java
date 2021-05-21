package br.com.zupacademy.vitor.casadocodigo.dto;

import br.com.zupacademy.vitor.casadocodigo.modelo.Livro;

public class DetalhesLivrosDto {
	
	private String titulo;
	private String sumario;
	private double preco;
	private String resumo;
	private String autor;
	private Integer numPaginas;
	private String isbn;
	
	public DetalhesLivrosDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.autor = livro.getAutor().getNome();
		this.numPaginas = livro.getNumPag();
		this.isbn = livro.getIsbn();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSumario() {
		return sumario;
	}

	public double getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public String getIsbn() {
		return isbn;
	}
	

}
