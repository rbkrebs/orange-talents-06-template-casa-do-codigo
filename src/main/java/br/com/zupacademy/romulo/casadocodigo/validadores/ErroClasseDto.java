package br.com.zupacademy.romulo.casadocodigo.validadores;

public class ErroClasseDto {

    private String mensagem;

    public ErroClasseDto(String mensagem) {

        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
