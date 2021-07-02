package br.com.zupacademy.romulo.casadocodigo.autor;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class RequestAutorDetalhe {

    @JsonProperty
    @NotBlank
    private String nome;
    @JsonProperty
    @NotBlank
    private String descricao;

    public RequestAutorDetalhe(@NotBlank String nome, @NotBlank String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
