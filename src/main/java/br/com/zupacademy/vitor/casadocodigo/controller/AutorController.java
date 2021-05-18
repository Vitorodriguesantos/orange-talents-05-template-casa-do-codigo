package br.com.zupacademy.vitor.casadocodigo.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;

import br.com.zupacademy.vitor.casadocodigo.dto.FormAutor;
import br.com.zupacademy.vitor.casadocodigo.modelo.Autor;
import br.com.zupacademy.vitor.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	@Transactional
	public String novoAutor(@RequestBody @Valid FormAutor form) {
		Optional<Autor> verificaEmail = autorRepository.findByEmail(form.getEmail());
		if(verificaEmail.isPresent()) {
			return ("O e-mail "+form.getEmail()+" ja possui cadastro no sistema.");
		}
		Autor autor = new Autor(form.getNome(), form.getEmail(), form.getDescricao());
		autorRepository.save(autor);
		return autor.toString();
	}

}
