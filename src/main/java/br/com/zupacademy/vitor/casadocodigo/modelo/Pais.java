package br.com.zupacademy.vitor.casadocodigo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	
	public Pais() {
		
	}
	
	public Pais(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "{ id: "+id+", nome: "+nome+"}"; 
	}
	

}
