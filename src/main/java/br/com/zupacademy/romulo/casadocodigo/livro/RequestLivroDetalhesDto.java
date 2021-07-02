package br.com.zupacademy.romulo.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class RequestLivroDetalhesDto {



    @JsonProperty
    private String titulo;
    @JsonProperty
    private String resumo;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private String sumario;
    @JsonProperty
    private String autorNome;
    @JsonProperty
    private String autorDescricao;
    @JsonProperty
    private Integer paginas;
    @JsonProperty
    private String Isbn;

    public RequestLivroDetalhesDto(@NotBlank String titulo,
                                   @NotBlank String resumo,
                                   @NotBlank BigDecimal valor,
                                   @NotBlank String sumario,
                                   @NotBlank String autorNome,
                                   @NotBlank String autorDescricao,
                                   @NotBlank Integer paginas,
                                   @NotBlank String isbn) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.valor = valor;
        this.sumario = sumario;
        this.autorNome = autorNome;
        this.autorDescricao = autorDescricao;
        this.paginas = paginas;
        Isbn = isbn;
    }


    public static RequestLivroDetalhesDto detalhar(Livro livro) {


        RequestLivroDetalhesDto livroDetalhado = new RequestLivroDetalhesDto(

                livro.getTitulo(),
                livro.getResumoLivro(),
                livro.getPreco(),
                livro.getSumario(),
                livro.getAutor().getNome(),
                livro.getAutor().getDescricao(),
                livro.getNumeroPaginas(),
                livro.getIsbn() );

        return livroDetalhado;


    }
}
