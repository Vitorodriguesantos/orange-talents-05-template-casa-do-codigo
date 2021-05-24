package br.com.zupacademy.vitor.casadocodigo.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {VerificaIdValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VerificaId {
	
	String message() default "Tentativa de inserção com ID inválido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String uCampo();
	Class<?> aClasse();
}
