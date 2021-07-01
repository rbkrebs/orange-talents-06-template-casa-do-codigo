package br.com.zupacademy.romulo.casadocodigo.autor;


import br.com.zupacademy.romulo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.romulo.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.romulo.casadocodigo.categoria.FormCategoriaDto;
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

        autorRepository.save(autor);

        return ResponseEntity.ok(FormAutorDto.converteModelParaDto(autor));


    }


}
