package br.com.zupacademy.romulo.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResquestLivroDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String nome;

    public ResquestLivroDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static List<ResquestLivroDto> fromLivroModel(EntityManager entityManager) {

        List<ResquestLivroDto> resquestLivroDtos = new ArrayList<>();

        TypedQuery query = entityManager.createQuery("SELECT l FROM Livro l", Livro.class);
        List<Livro> livros = query.getResultList();
        for (Livro livro: livros){
            resquestLivroDtos.add(new ResquestLivroDto(livro.getId(), livro.getTitulo()));
        }

        return resquestLivroDtos;
    }


}
