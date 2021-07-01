package br.com.zupacademy.romulo.casadocodigo.livro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {


    @PostMapping
    public ResponseEntity<Livro> cadastra(FormLivroDto formLivroDto){

        Livro fLivro = formLivroDto.salvar(formLivroDto);

        return ResponseEntity.ok().body(fLivro);

    }

}
