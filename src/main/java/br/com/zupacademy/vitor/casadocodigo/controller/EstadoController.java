package br.com.zupacademy.vitor.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.casadocodigo.dto.FormEstado;
import br.com.zupacademy.vitor.casadocodigo.modelo.Estado;
import br.com.zupacademy.vitor.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.vitor.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public String novoEstado(@RequestBody @Valid FormEstado form) {
		Estado novoEstado = form.converter(paisRepository);
		estadoRepository.save(novoEstado);
		return novoEstado.toString();
	}
	
}
