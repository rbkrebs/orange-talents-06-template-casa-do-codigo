package br.com.zupacademy.romulo.casadocodigo.pais;

import br.com.zupacademy.romulo.casadocodigo.validadores.ValorUnico;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.NotBlank;

public class FormPaisDto {

    @NotBlank
    @ValorUnico(entidade = "Pais", atributo = "nome")
    private String nome;


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public FormPaisDto(@NotBlank @ValorUnico(entidade = "Pais", atributo = "nome") String nome) {
        this.nome = nome;
    }

    public static Pais convertToModel(@NotBlank String formPaisDto){

        Pais pais = new Pais(formPaisDto);

        return pais;

    }

    public String getNome() {
        return this.nome;
    }


}
