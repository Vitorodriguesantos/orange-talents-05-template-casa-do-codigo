package br.com.zupacademy.vitor.casadocodigo.dto;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.zupacademy.vitor.casadocodigo.modelo.Estado;
import br.com.zupacademy.vitor.casadocodigo.modelo.Pais;
import br.com.zupacademy.vitor.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.vitor.casadocodigo.validacao.UniqueValue;

public class FormEstado {
	
	@UniqueValue(classeDominio = Estado.class,nomeCampo = "nome")
	@NotNull
	private String nome;
	@NotNull
	private Long pais;
	
	public FormEstado() {
		
	}

	public FormEstado(Estado estado) {
		super();
		this.nome = estado.getNome();
		this.pais = estado.getPais().getId();
	}

	public String getNome() {
		return nome;
	}

	public Long getPais() {
		return pais;
	}

	public Estado converter(PaisRepository paisRepository) {
		
			Optional<Pais> possivelPais = paisRepository.findById(pais);
			if(possivelPais.isEmpty()) {
				throw new IllegalArgumentException("Tentativa de cadastro com Id inválido");
			}
		return new Estado(nome, possivelPais.get());
	}
	
	
}
