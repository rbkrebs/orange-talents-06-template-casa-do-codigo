package br.com.zupacademy.romulo.casadocodigo.estado;

import br.com.zupacademy.romulo.casadocodigo.pais.Pais;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado, Long> {

    Optional<Estado> findByNomeAndPaisesId(String nome, Long Id);

    Optional<Estado> findByPaisesId(Long id);
}
