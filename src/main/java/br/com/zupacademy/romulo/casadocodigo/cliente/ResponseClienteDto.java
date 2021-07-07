package br.com.zupacademy.romulo.casadocodigo.cliente;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseClienteDto {


    @JsonProperty
    private Long id;


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    ResponseClienteDto(Long id){

        this.id = id;
    }


}
