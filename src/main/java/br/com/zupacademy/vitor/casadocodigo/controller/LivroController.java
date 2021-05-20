package br.com.zupacademy.vitor.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.casadocodigo.dto.FormLivro;
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
	public String novaCategoria(@RequestBody @Valid FormLivro form) {
		Livro livro = form.converter(autorRepository,categoriaRepository);
		livroRepository.save(livro);
		return livro.toString();
	}

}