package br.com.zupacademy.vitor.casadocodigo.dto;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.vitor.casadocodigo.modelo.Cliente;
import br.com.zupacademy.vitor.casadocodigo.modelo.Estado;
import br.com.zupacademy.vitor.casadocodigo.modelo.Pais;
import br.com.zupacademy.vitor.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.vitor.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.vitor.casadocodigo.validacao.CPFOrCNPJ;
import br.com.zupacademy.vitor.casadocodigo.validacao.UniqueValue;

public class FormCliente {
	
	@Email
	@UniqueValue(classeDominio = Cliente.class,nomeCampo = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@CPFOrCNPJ
	@UniqueValue(classeDominio = Cliente.class, nomeCampo = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	private Long pais;
	private Long estado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	public FormCliente() {
		
	}

	public FormCliente(@Email String email, @NotBlank String nome, @NotBlank String sobrenome, String documento,
			@NotBlank String endereco, String complemento, @NotBlank String cidade, @NotNull Long pais, Long estado,
			@NotBlank String telefone, @NotBlank String cep) {
		
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}



	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPais() {
		return pais;
	}

	public Long getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
			Optional<Pais> possivelPais = paisRepository.findById(pais);
			if(possivelPais.isEmpty()) {
				throw new IllegalArgumentException("Tentativa de cadastro com Id inválido");
			}
			Optional<Estado> possivelEstado = estadoRepository.findById(estado);
			
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, possivelPais.get(), possivelEstado.get(), telefone, cep);
	}
	
	

}
