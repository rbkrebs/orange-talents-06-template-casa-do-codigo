package br.com.zupacademy.romulo.casadocodigo.autor;



import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O campo email é obrigatório")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "O campo descrição é obrigatório")
    @Size(max = 400, message = "Máximo de {max} caracteres")
    @Column(nullable = false)
    private String descricao;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant criadoEm;


    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
