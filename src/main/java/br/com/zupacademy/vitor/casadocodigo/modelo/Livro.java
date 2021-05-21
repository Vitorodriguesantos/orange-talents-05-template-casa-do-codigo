package br.com.zupacademy.vitor.casadocodigo.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@Lob
	private String sumario;
	@NotNull
	@Min(value = 20)
	private double preco;
	@NotNull
	@Min(value = 20)
	private Integer numPag;
	@NotBlank
	private String Isbn;
	@Future
	private LocalDate dataPublicacao;
	@NotNull
	@ManyToOne
	private Autor autor;
	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public double getPreco() {
		return preco;
	}

	public Integer getNumPag() {
		return numPag;
	}

	public String getIsbn() {
		return Isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	public Livro(){
		
	}

	public Livro( @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) double preco, @NotNull @Min(20) Integer numPag, @NotBlank String isbn,
			@Future LocalDate dataPublicacao, Autor autor, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numPag = numPag;
		Isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "{id: "+id+", titulo: "+titulo+", resumo: "+resumo+", sumario: "+sumario+", preco: "+preco
				+", numPaginas: "+numPag+", Isbn: "+Isbn+", dataPublica: "+dataPublicacao+", autor: "+autor.getNome()
				+", categoria: "+categoria.getNome()+"}"; 
	}
	
	

}
