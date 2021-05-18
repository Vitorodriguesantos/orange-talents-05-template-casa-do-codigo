package br.com.zupacademy.vitor.casadocodigo.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.vitor.casadocodigo.dto.FormAutor;
import br.com.zupacademy.vitor.casadocodigo.modelo.Autor;
import br.com.zupacademy.vitor.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator{

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return FormAutor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		FormAutor request = (FormAutor) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um autor/autora com esse e-mail cadastrado. " 
														+ request.getEmail());
		}
	}

}
