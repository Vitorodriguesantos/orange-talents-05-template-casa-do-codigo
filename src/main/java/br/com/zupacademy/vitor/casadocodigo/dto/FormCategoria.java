package br.com.zupacademy.vitor.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.vitor.casadocodigo.modelo.Categoria;
import br.com.zupacademy.vitor.casadocodigo.validacao.UniqueValue;

public class FormCategoria {
	
	@NotBlank
	@UniqueValue(classeDominio = Categoria.class,nomeCampo = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
