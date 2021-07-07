package br.com.zupacademy.romulo.casadocodigo.cliente;


import br.com.zupacademy.romulo.casadocodigo.estado.Estado;
import br.com.zupacademy.romulo.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String sobreNome;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String documento;

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
    @ManyToOne
    private Pais pais;


    @ManyToOne
    private Estado estado;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotBlank
    @Column(nullable = false)
    private String cep;

    @Deprecated
    Cliente(){}

    public Cliente(String nome, String sobreNome, String documento, String cidade, String email, String endereco, String complemento, Pais pais, Estado estado, String telefone, String cep) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.cidade = cidade;
        this.email = email;
        this.endereco = endereco;
        this.complemento = complemento;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {

        return this.id;
    }
}
