package br.com.zupacademy.romulo.casadocodigo.categoria;


import br.com.zupacademy.romulo.casadocodigo.autor.ValorUnico;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class FormCategoriaDto {

    @NotBlank(message = "Campo obrigatório")
    @ValorUnico(entidade = "Categoria", atributo = "nome")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public FormCategoriaDto(String nome) {
        this.nome = nome;
    }

    public static Categoria converteDtoParaModel(FormCategoriaDto formCategoriaDto){

        return new Categoria(formCategoriaDto.getNome());

    }

    public static FormCategoriaDto converteModelParaDto(Categoria categoria){

        return new FormCategoriaDto(categoria.getNome());

    }

    public String getNome() {
        return nome;
    }
}
