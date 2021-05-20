package br.com.zupacademy.vitor.casadocodigo.dto;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.vitor.casadocodigo.modelo.Autor;
import br.com.zupacademy.vitor.casadocodigo.modelo.Categoria;
import br.com.zupacademy.vitor.casadocodigo.modelo.Livro;
import br.com.zupacademy.vitor.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.vitor.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.vitor.casadocodigo.validacao.UniqueValue;

public class FormLivro {

	@NotBlank
	@UniqueValue(classeDominio = Livro.class,nomeCampo = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	private String sumario;
	@NotNull
	@Min(value = 20)
	private double preco;
	@NotNull
	@Min(value = 100)
	private Integer numPag;
	@NotBlank
	@UniqueValue(classeDominio = Livro.class,nomeCampo = "Isbn")
	private String Isbn;
	@Future
	private LocalDate dataPublicacao;
	@NotNull
	private Long autor;
	@NotNull
	private Long categoria;
	
	public String getTitulo() {
		return titulo;
	}
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
	public Long getAutor() {
		return autor;
	}
	public Long getCategoria() {
		return categoria;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public void setSumario(String sumario) {
		this.sumario = sumario;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void setNumPag(Integer numPag) {
		this.numPag = numPag;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public void setAutor(Long autor) {
		this.autor = autor;
	}
	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}
	
	public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Optional<Autor> possivelAutor = autorRepository.findById(autor);
		Optional<Categoria> possivelCategoria = categoriaRepository.findById(categoria);
		return new Livro(titulo, resumo, sumario, preco, numPag, Isbn, dataPublicacao, possivelAutor.get(),possivelCategoria.get());
		}
	
	
	
}
