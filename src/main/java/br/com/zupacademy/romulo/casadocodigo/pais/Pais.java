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


    public Pais(String nome) {
        this.nome = nome;
    }


    public String getNome() {

        return this.nome;
    }
}
