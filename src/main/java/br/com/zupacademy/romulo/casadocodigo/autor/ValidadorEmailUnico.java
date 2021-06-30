package br.com.zupacademy.romulo.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorEmailUnico implements ConstraintValidator<EmailValidatorAnnotation, String> {

    @Autowired
    private AutorRepository repository;

    @Override
    public void initialize(EmailValidatorAnnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return !this.repository.findByEmail(s).isPresent();
    }
}
