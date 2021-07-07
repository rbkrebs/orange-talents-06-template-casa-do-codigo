package br.com.zupacademy.romulo.casadocodigo.validadores;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorPaisComEstado.class)
public @interface PaisComEstado {

    String message() default "País com estados cadastrados, favor informar o estado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
