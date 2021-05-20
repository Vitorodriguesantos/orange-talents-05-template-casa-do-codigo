package br.com.zupacademy.vitor.casadocodigo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.vitor.casadocodigo.modelo.Livro;

public class ListaLivrosDto {
	
	private Long id;
	private String nome;
	
	public ListaLivrosDto() {
		
	}
	
	public ListaLivrosDto(Livro livro) {
		this.id = livro.getId();
		this.nome = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static List<ListaLivrosDto> converter(List<Livro> livros) {
		
		return livros.stream().map(ListaLivrosDto::new).collect(Collectors.toList());
	}
	
	

}
