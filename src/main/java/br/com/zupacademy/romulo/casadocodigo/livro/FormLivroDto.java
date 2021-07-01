package br.com.zupacademy.romulo.casadocodigo.livro;

import br.com.zupacademy.romulo.casadocodigo.autor.Autor;
import br.com.zupacademy.romulo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.romulo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.romulo.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.romulo.casadocodigo.validadores.ExisteRegistro;
import br.com.zupacademy.romulo.casadocodigo.validadores.ValorUnico;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FormLivroDto {

    @JsonProperty
    @NotBlank
    @ValorUnico(atributo = "titulo", entidade = "Titulo")
    private String titulo;

    @JsonProperty
    @NotBlank
    @Size(max = 500, message = "Valor máximo de {max}")
    private String resumo;

    @JsonProperty
    private String sumario;

    @JsonProperty
    @NotBlank
    @Min(value = 20, message = "valor mínimo de {value}")
    private BigDecimal preco;

    @JsonProperty
    @NotBlank
    @Min(value = 100, message = "valor mínimo de {value}")
    private Integer numeroPaginas;

    @JsonProperty
    @NotBlank
    @ValorUnico(entidade = "Livro", atributo = "isbn")
    private String isbn;

    @JsonProperty
    @Future
    private LocalDateTime dataLancamento;

    @NotBlank
    @ExisteRegistro(entidade = "Categoria", atributo = "id")
    private Long idCategoria;

    @NotBlank
    @ExisteRegistro(entidade = "Autor", atributo = "id")
    private Long idAutor;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    LivroRepository livroRepository;


    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Livro salvar(FormLivroDto formLivroDto) {

        Categoria categoria = categoriaRepository.findById(formLivroDto.getIdCategoria()).get();
        Autor autor = autorRepository.findById(formLivroDto.getIdAutor()).get();

        Livro livro = new Livro(formLivroDto.titulo,
                                formLivroDto.resumo,
                                formLivroDto.sumario,
                                formLivroDto.preco,
                                formLivroDto.numeroPaginas,
                                formLivroDto.isbn,
                                formLivroDto.dataLancamento,
                                categoria, autor);

        return livro;

    }


}
