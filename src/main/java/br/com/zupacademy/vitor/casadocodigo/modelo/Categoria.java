package br.com.zupacademy.vitor.casadocodigo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	
	public Categoria() {
		
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "{id: "+id+", nome: "+nome+"}"; 
	}

	public String getNome() {
		return nome;
	}

}
