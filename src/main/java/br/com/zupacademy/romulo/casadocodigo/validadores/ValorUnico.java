package br.com.zupacademy.romulo.casadocodigo.validadores;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorGenerico.class)
public @interface ValorUnico {

    String message() default "Valor já cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    String value() default "";

    String entidade () default "";

    String atributo () default "";


}

