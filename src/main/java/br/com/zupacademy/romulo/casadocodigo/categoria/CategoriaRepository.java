package br.com.zupacademy.romulo.casadocodigo.categoria;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
