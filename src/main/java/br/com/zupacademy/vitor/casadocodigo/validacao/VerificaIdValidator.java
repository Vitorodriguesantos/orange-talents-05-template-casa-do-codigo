package br.com.zupacademy.vitor.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class VerificaIdValidator implements ConstraintValidator<VerificaId, Object>{

	private String oAtributo;
	private Class<?> aClass;
	@PersistenceContext
	private EntityManager manager;
	
	public void initialize(VerificaId osDados) {
		oAtributo = osDados.uCampo();
		aClass = osDados.aClasse();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query aQuery = manager.createQuery("Select 1 from "+aClass.getName()+" where "+oAtributo+"=:value");
		aQuery.setParameter("value", value);
		List<?> aList = aQuery.getResultList();
		Assert.state(aList.size() >= 0, "Registro não existente");
		return !aList.isEmpty();
	}
}
