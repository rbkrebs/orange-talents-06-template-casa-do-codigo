package br.com.zupacademy.romulo.casadocodigo.validadores;

import br.com.zupacademy.romulo.casadocodigo.estado.Estado;
import br.com.zupacademy.romulo.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.romulo.casadocodigo.estado.FormEstadoDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ValidadorForeingKeyUnica implements ConstraintValidator<ForeignKeyUnica, FormEstadoDto> {

    @Autowired
    private EstadoRepository er;



    @Override
    public void initialize(ForeignKeyUnica constraintAnnotation) {


        ConstraintValidator.super.initialize(constraintAnnotation);

    }

    @Override
    public boolean isValid(FormEstadoDto eDto, ConstraintValidatorContext constraintValidatorContext) {

        Boolean valid = er.findByNomeAndPaisesId(eDto.getNome(), eDto.getIdPais()).isEmpty();

        return valid;
    }
}
