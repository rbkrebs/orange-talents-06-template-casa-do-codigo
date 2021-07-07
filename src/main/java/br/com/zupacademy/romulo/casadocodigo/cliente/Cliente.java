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
    @ManyToOne
    private Pais pais;

    @Column(nullable = true)
    @ManyToOne
    private Estado estado;

    @NotNull
    @Column(nullable = false)
    private Integer telefone;

    @NotNull
    @Column(nullable = false)
    private Integer cep;

    public Cliente(String nome,
                   String sobreNome,
                   Integer documento,
                   String cidade,
                   String email,
                   String endereco,
                   String complemento,
                   Pais pais,
                   Estado estado,
                   Integer telefone,
                   Integer cep) {
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
}
