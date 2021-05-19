package br.com.zupacademy.vitor.casadocodigo.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.vitor.casadocodigo.dto.FormCategoria;
import br.com.zupacademy.vitor.casadocodigo.modelo.Categoria;
import br.com.zupacademy.vitor.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeCategoriaDuplicada implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return FormCategoria.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		FormCategoria request = (FormCategoria) target;
		Optional<Categoria> possivelCategoria =  categoriaRepository.findByNome(request.getNome());
		System.out.println("CATEGORIA: "+request.getNome());
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("categoria", null, "Já existe uma categoria "+request.getNome()+" cadastrada.");
		}
		
	}

}
