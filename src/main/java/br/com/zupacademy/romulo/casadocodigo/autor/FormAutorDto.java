package br.com.zupacademy.romulo.casadocodigo.autor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FormAutorDto {

    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "O campo email é obrigatório")
    @Email(message = "Campo email em formato não válido")
    private String email;
    @NotBlank(message = "O campo descrição é obrigatório")
    @Size(max = 400, message = "Máximo de {max} caracteres")
    private String descricao;

    public FormAutorDto(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Autor converteDtoParaModel(FormAutorDto formAutorDto){

        return new Autor(formAutorDto.getNome(),
                        formAutorDto.getEmail(),
                        formAutorDto.getDescricao());

    }
}
