package br.com.zupacademy.romulo.casadocodigo.livro;

import br.com.zupacademy.romulo.casadocodigo.autor.Autor;
import br.com.zupacademy.romulo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.romulo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.romulo.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.romulo.casadocodigo.validadores.ExisteRegistro;
import br.com.zupacademy.romulo.casadocodigo.validadores.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FormLivroDto {

    @JsonProperty
    @NotBlank
    @ValorUnico(atributo = "titulo", entidade = "Livro")
    private String titulo;

    @JsonProperty
    @NotBlank
    @Size(max = 500, message = "Valor máximo de {max}")
    private String resumo;

    @JsonProperty
    @NotBlank
    private String sumario;

    @JsonProperty
    @NotNull
    @Min(value = 20, message = "valor mínimo de {value}")
    private BigDecimal preco;

    @JsonProperty
    @NotNull
    @Min(value = 100, message = "valor mínimo de {value}")
    private Integer numeroPaginas;

    @JsonProperty
    @NotBlank
    @ValorUnico(entidade = "Livro", atributo = "isbn")
    private String isbn;

    @JsonProperty
    @Future
    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @NotNull
    @ExisteRegistro(entidade = "Categoria", atributo = "id")
    private Long idCategoria;

    @NotNull
    @ExisteRegistro(entidade = "Autor", atributo = "id")
    private Long idAutor;




    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }



    public Livro salvar(FormLivroDto formLivroDto, EntityManager entityManager) {


        Autor autor = entityManager.find(Autor.class, idAutor);
        Categoria categoria = entityManager.find(Categoria.class, idCategoria);


        return new Livro(formLivroDto.titulo,
                                formLivroDto.resumo,
                                formLivroDto.sumario,
                                formLivroDto.preco,
                                formLivroDto.numeroPaginas,
                                formLivroDto.isbn,
                                formLivroDto.dataLancamento,
                                categoria, autor);




    }


}
