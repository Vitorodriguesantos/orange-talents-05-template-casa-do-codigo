package br.com.zupacademy.vitor.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.vitor.casadocodigo.modelo.Autor;
import br.com.zupacademy.vitor.casadocodigo.validacao.UniqueValue;

public class FormAutor {
	
	@NotBlank
	private String nome;
	@Email
	@UniqueValue(classeDominio = Autor.class,nomeCampo = "email")
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	
	public FormAutor() {
		
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
