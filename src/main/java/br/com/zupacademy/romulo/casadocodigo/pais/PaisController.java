package br.com.zupacademy.romulo.casadocodigo.pais;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid FormPaisDto formPaisDto){

        FormPaisDto fPaisDto = FormPaisDto.convertToModel(formPaisDto, em);

        return ResponseEntity.ok(formPaisDto);
    }
}
