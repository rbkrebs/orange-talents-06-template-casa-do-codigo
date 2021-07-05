package br.com.zupacademy.romulo.casadocodigo.validadores;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorForeingKeyUnica.class)
public @interface ForeignKeyUnica {

    String message() default "Registro já possui essa chave estrangeira";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
