package br.com.zupacademy.vitor.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.casadocodigo.dto.FormCategoria;
import br.com.zupacademy.vitor.casadocodigo.modelo.Categoria;
import br.com.zupacademy.vitor.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.vitor.casadocodigo.validacao.ProibeCategoriaDuplicada;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProibeCategoriaDuplicada proibeCategoriaDuplicada;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeCategoriaDuplicada);
	}
	
	@PostMapping
	@Transactional
	public String novaCategoria(@RequestBody @Valid FormCategoria form) {
		Categoria categoria = new Categoria(form.getNome());
		categoriaRepository.save(categoria);
		return categoria.toString();
	}

}
