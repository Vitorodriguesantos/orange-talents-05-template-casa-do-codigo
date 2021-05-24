package br.com.zupacademy.vitor.casadocodigo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@ManyToOne
	private Pais pais;
	
	public Estado() {
		
	}

	public Estado(@NotBlank String nome, @NotEmpty @NotNull Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
	
	@Override
	public String toString() {
		return "{id: "+id+", nome: "+nome+", pais: "+pais+"}";
	}
	
}
