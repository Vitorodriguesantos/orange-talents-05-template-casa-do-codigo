package br.com.zupacademy.vitor.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object>{

	private String nomeAtributo;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;
	
	public void initialize(UniqueValue params) {
		nomeAtributo = params.nomeCampo();
		klass = params.classeDominio();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("Select 1 from "+klass.getName()+" where "+nomeAtributo+"=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1, "Foi encontrado mais de um "+klass+" com o atributo "+nomeAtributo+" = "+value);
		return list.isEmpty();
	}

}
