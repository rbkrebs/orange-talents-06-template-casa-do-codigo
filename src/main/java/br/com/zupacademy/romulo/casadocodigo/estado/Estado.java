package br.com.zupacademy.romulo.casadocodigo.estado;

import br.com.zupacademy.romulo.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String estado;

    @ManyToOne
    private Pais paises;


}
