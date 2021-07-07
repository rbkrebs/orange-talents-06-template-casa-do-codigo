package br.com.zupacademy.romulo.casadocodigo.cliente;


import br.com.zupacademy.romulo.casadocodigo.estado.Estado;
import br.com.zupacademy.romulo.casadocodigo.pais.Pais;
import br.com.zupacademy.romulo.casadocodigo.validadores.ExisteRegistro;
import br.com.zupacademy.romulo.casadocodigo.validadores.PaisComEstado;
import br.com.zupacademy.romulo.casadocodigo.validadores.ValorUnico;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@PaisComEstado
public class FormClienteDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @ValorUnico(entidade = "Cliente", atributo = "documento")
    private String documento;

    @NotBlank
    private String cidade;

    @Email
    @ValorUnico(entidade = "Cliente", atributo = "email")
    private String email;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotNull
    @ExisteRegistro(entidade = "Pais", atributo = "id")
    private Long idPais;


    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;


    public FormClienteDto(String nome, String sobrenome, String documento, String cidade, String email, String endereco, String complemento, Long idPais, Long idEstado, String telefone, String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.cidade = cidade;
        this.email = email;
        this.endereco = endereco;
        this.complemento = complemento;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getIdPais() {
        return idPais;
    }



    public Long getIdEstado() {

        return idEstado;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public static ResponseClienteDto converteToModel(FormClienteDto fcDto, EntityManager entityManager) {

        Pais pais = entityManager.find(Pais.class, fcDto.getIdPais());
        Estado estado = null;
        if(fcDto.getIdEstado() != null){
           estado = entityManager.find(Estado.class, fcDto.getIdEstado());
        }


        Cliente cliente = new Cliente(fcDto.getNome(),
                                        fcDto.getSobrenome(),
                                        fcDto.getDocumento(),
                                        fcDto.getCidade(),
                                        fcDto.getEmail(),
                                        fcDto.getEndereco(),
                                        fcDto.getComplemento(),
                                        pais,
                                        estado,
                                        fcDto.getTelefone(),
                                        fcDto.getCep());
        entityManager.persist(cliente);
        ResponseClienteDto responseClienteDto = ResponseClienteDto.covertDto(cliente);
        return responseClienteDto;

    }
}
