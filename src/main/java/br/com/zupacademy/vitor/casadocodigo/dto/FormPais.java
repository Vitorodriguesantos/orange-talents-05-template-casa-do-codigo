package br.com.zupacademy.vitor.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.vitor.casadocodigo.modelo.Pais;
import br.com.zupacademy.vitor.casadocodigo.validacao.UniqueValue;

public class FormPais {
	
	@NotBlank
	@UniqueValue(classeDominio = Pais.class,nomeCampo = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}
	
}
