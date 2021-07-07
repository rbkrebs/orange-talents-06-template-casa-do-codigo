package br.com.zupacademy.romulo.casadocodigo.validadores;

import br.com.zupacademy.romulo.casadocodigo.cliente.FormClienteDto;
import br.com.zupacademy.romulo.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.romulo.casadocodigo.pais.Pais;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class ValidadorPaisComEstado implements ConstraintValidator<PaisComEstado, FormClienteDto> {

    @Autowired
    private EstadoRepository er;


    @Override
    public void initialize(PaisComEstado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(FormClienteDto formClienteDto, ConstraintValidatorContext constraintValidatorContext) {

            Boolean valid = er.findByIdAndPaisesId(formClienteDto.getIdEstado(), formClienteDto.getIdPais()).isEmpty();
          
            return !valid;

    }
}
