package br.com.zupacademy.romulo.casadocodigo.validadores;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerificaRegistro implements ConstraintValidator<ExisteRegistro, Long> {

    @Autowired
    private EntityManager em;

    private String atributo;

    private String tabela;

    @Override
    public void initialize(ExisteRegistro constraintAnnotation) {

        this.atributo = constraintAnnotation.atributo();
        this.tabela = constraintAnnotation.entidade();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {

        Query query = em.createQuery("SELECT s FROM "+this.tabela+" s where "+this.atributo+"= :id")
                .setParameter("id",id);

        return !query.getResultList().isEmpty();
    }
}
