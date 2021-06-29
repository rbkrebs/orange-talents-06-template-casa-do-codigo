package br.com.zupacademy.romulo.casadocodigo.autor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid FormAutorDto formAutorDto){

        Autor autor = FormAutorDto.converteDtoParaModel(formAutorDto);
        try{
            autorRepository.save(autor);

            return ResponseEntity.ok(new FormAutorDto(autor.getNome(),autor.getEmail(), autor.getDescricao()));

        }catch (Exception e){

            return ResponseEntity.badRequest().body(e);
        }



    }
}
