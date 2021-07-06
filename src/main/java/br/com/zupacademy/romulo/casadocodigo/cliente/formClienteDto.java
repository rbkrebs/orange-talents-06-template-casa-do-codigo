package br.com.zupacademy.romulo.casadocodigo.cliente;

import br.com.zupacademy.romulo.casadocodigo.estado.Estado;
import br.com.zupacademy.romulo.casadocodigo.pais.Pais;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class formClienteDto {

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String sobreNome;

    @NotNull
    @Column(nullable = false, unique = true)
    private Integer documento;

    @NotBlank
    @Column(nullable = false)
    private String cidade;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotBlank
    @Column(nullable = false)
    private String complemento;

    @NotNull
    @Column(nullable = false)
    private Pais pais;

    private Estado estado;

    @NotNull
    @Column(nullable = false)
    private Integer telefone;

    @NotNull
    @Column(nullable = false)
    private Integer cep;

}
