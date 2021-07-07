package br.com.zupacademy.romulo.casadocodigo.cliente;


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
@RequestMapping("/cliente")
public class ClienteController {


    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseClienteDto> cadastrar(@RequestBody @Valid FormClienteDto fcDto){

            ResponseClienteDto responseClienteDto = FormClienteDto.converteToModel(fcDto, entityManager);

            return ResponseEntity.ok(responseClienteDto);
    }
}
