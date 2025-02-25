package br.com.zupacademy.vitor.casadocodigo.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.casadocodigo.dto.DetalhesLivrosDto;
import br.com.zupacademy.vitor.casadocodigo.dto.FormLivro;
import br.com.zupacademy.vitor.casadocodigo.dto.ListaLivrosDto;
import br.com.zupacademy.vitor.casadocodigo.modelo.Livro;
import br.com.zupacademy.vitor.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.vitor.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.vitor.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public String novoLivro(@RequestBody @Valid FormLivro form) {
		Livro livro = form.converter(autorRepository,categoriaRepository);
		livroRepository.save(livro);
		return livro.toString();
	}
	
	@GetMapping
	public List<ListaLivrosDto> listarLivros(){
		List<Livro> livros = livroRepository.findAll();
		return ListaLivrosDto.converter(livros);
	}
	
	@GetMapping("/{titulo}")
	public ResponseEntity<DetalhesLivrosDto> detalhar(@PathVariable String titulo) {
		System.out.println(titulo);
		Optional<Livro> livro = livroRepository.findByTitulo(titulo);
		System.out.println(livro);
		if(livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesLivrosDto(livro.get()));
		}
		return ResponseEntity.notFound().build();
		
	}

}
