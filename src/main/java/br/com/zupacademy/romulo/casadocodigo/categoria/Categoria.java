package br.com.zupacademy.romulo.casadocodigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório")
    @Column(nullable = false)
    private String nome;


    @Deprecated
    public Categoria() {
    }

    public Categoria( String nome) {

        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "Nome='" + nome + '\'' +
                '}';
    }
}
