package br.com.zupacademy.romulo.casadocodigo.pais;

import br.com.zupacademy.romulo.casadocodigo.validadores.ValorUnico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class FormPaisDto {

    @NotBlank
    @ValorUnico
    private String nome;

    public FormPaisDto(String nome) {
        this.nome = nome;
    }

    public static FormPaisDto convertToModel(@NotBlank @ValorUnico FormPaisDto formPaisDto, EntityManager entityManager){

        entityManager.persist(new Pais(formPaisDto.getNome()));

        return formPaisDto;

    }

    private String getNome() {
        return this.nome;
    }
}
