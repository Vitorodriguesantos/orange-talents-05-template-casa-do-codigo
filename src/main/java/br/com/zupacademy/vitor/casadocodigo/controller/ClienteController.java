package br.com.zupacademy.vitor.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.vitor.casadocodigo.dto.FormCliente;
import br.com.zupacademy.vitor.casadocodigo.modelo.Cliente;
import br.com.zupacademy.vitor.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.vitor.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.vitor.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired EstadoRepository estadoRepository;
	
	@PostMapping
	@Transactional
	public String novoCliente(@RequestBody @Valid FormCliente form) {
		Cliente novoCliente = form.converter(paisRepository, estadoRepository);
		clienteRepository.save(novoCliente);
		return novoCliente.toString();
	}
}
