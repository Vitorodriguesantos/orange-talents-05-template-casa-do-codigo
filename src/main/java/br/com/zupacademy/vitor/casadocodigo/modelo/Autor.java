package br.com.zupacademy.vitor.casadocodigo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Autor() {
		
	}


	public String getNome() {
		return nome;
	}

	public Autor(String nome, String email, String descricao) {
		
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "["+id+", "+nome+", "+email+", "+descricao+", "+dataCriacao+"]"; 
	}
	
	
}
