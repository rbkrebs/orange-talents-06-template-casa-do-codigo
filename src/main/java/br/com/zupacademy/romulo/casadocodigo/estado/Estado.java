package br.com.zupacademy.romulo.casadocodigo.estado;

import br.com.zupacademy.romulo.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;


    @NotNull
    @ManyToOne

    private Pais paises;

    @Deprecated
    public Estado(){};

    public Estado(@NotBlank String nome, @NotBlank Pais paises) {
        this.nome = nome;
        this.paises = paises;
    }
}
