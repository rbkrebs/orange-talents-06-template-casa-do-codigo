package br.com.zupacademy.romulo.casadocodigo.cliente;

import br.com.zupacademy.romulo.casadocodigo.estado.Estado;
import br.com.zupacademy.romulo.casadocodigo.pais.Pais;
import br.com.zupacademy.romulo.casadocodigo.validadores.PaisComEstado;
import br.com.zupacademy.romulo.casadocodigo.validadores.ValorUnico;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@PaisComEstado
public class FormClienteDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobreNome;

    @NotNull
    @ValorUnico(entidade = "Cliente", atributo = "documento")
    private Integer documento;

    @NotBlank
    private String cidade;

    @Email
    @ValorUnico(entidade = "Cliente", atributo = "email")
    private String email;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotNull
    private Long idPais;

    private Long idEstado;

    @NotNull
    private Integer telefone;

    @NotNull
    private Integer cep;


    public Long getIdPais() {
        return idPais;
    }

    public static ResponseClienteDto converteToModel(FormClienteDto fcDto, EntityManager entityManager) {
return null;

    }
}
