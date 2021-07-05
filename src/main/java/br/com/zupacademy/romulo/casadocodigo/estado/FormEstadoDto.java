package br.com.zupacademy.romulo.casadocodigo.estado;

import br.com.zupacademy.romulo.casadocodigo.pais.Pais;
import br.com.zupacademy.romulo.casadocodigo.validadores.ExisteRegistro;
import br.com.zupacademy.romulo.casadocodigo.validadores.ForeignKeyUnica;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ForeignKeyUnica
public class FormEstadoDto {

    @JsonProperty
    @NotBlank
    private String nome;

    @JsonProperty
    @NotNull
    @ExisteRegistro(entidade = "Pais", atributo = "id")

    private Long IdPais;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public FormEstadoDto(@NotBlank String nome,
                         @NotNull @ExisteRegistro(entidade = "Pais", atributo = "id")
                         Long idPais) {
        this.nome = nome;
        this.IdPais = idPais;
    }

    public Long getIdPais() {
        return IdPais;
    }
    public String getNome() {

        return this.nome;
    }

    public static Estado converteEstado(FormEstadoDto formEstadoDto, EntityManager em) {

        Pais pais = em.find(Pais.class, formEstadoDto.getIdPais());
        return new Estado(formEstadoDto.getNome(), pais);


    }
}
