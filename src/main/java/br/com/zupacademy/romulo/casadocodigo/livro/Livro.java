package br.com.zupacademy.romulo.casadocodigo.livro;


import br.com.zupacademy.romulo.casadocodigo.autor.Autor;
import br.com.zupacademy.romulo.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String titulo;

    @NotBlank
    @Column(nullable = false, length = 500)
    private String resumoLivro;

    @Lob
    private String sumario;

    @Min(20)
    @Column(nullable = false)
    private BigDecimal preco;

    @Min(100)
    @Column(nullable = false)
    private Integer numeroPaginas;


    @NotBlank
    @Column(nullable = false, unique = true)
    private String isbn;

    @Future
    private LocalDateTime dataLancamento;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;



    public Livro(String titulo, String resumoLivro, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDateTime dataLancamento, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumoLivro = resumoLivro;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "Título='" + titulo + '\'' +
                ", Resumo do livro='" + resumoLivro + '\'' +
                ", Sumário='" + sumario + '\'' +
                ", Preço=" + preco +
                ", Número de Páginas=" + numeroPaginas +
                ", ISBN='" + isbn + '\'' +
                ", Data de Lançamento=" + dataLancamento +
                ", Categoria=" + categoria +
                ", Autor=" + autor +
                '}';
    }
}
