package br.com.zupacademy.romulo.casadocodigo.pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;


    @Deprecated
    public Pais(){};
    public Pais(String nome) {
        this.nome = nome;
    }


}
