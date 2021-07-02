package br.com.zupacademy.romulo.casadocodigo.livro;


import br.com.zupacademy.romulo.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.romulo.casadocodigo.categoria.CategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity cadastra(@RequestBody @Valid FormLivroDto formLivroDto){

        Livro fLivro = formLivroDto.salvar(formLivroDto, entityManager);

        entityManager.persist(fLivro);

        return ResponseEntity.ok(fLivro.toString());

    }

    @GetMapping
    public ResponseEntity listar() {

        List<ResquestLivroDto> livros = ResquestLivroDto.fromLivroModel(entityManager);

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalheLivro(@PathVariable @Valid  Long id) {

        Livro livro = entityManager.find(Livro.class, id);

        if(livro == null){
            return ResponseEntity.notFound().build();
        }

        RequestLivroDetalhesDto livroDetalhesDto = RequestLivroDetalhesDto.detalhar(livro);

        return ResponseEntity.ok(livroDetalhesDto);

    }
    

}
