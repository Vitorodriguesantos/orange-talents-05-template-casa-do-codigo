package br.com.zupacademy.vitor.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.casadocodigo.dto.FormPais;
import br.com.zupacademy.vitor.casadocodigo.modelo.Pais;
import br.com.zupacademy.vitor.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public String novoPais(@RequestBody @Valid FormPais form) {
		Pais novoPais = new Pais(form.getNome());
		paisRepository.save(novoPais);
		return novoPais.toString();
	}
	
}
