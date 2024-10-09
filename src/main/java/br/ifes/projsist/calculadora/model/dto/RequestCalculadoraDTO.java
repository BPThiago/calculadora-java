package br.ifes.projsist.calculadora.model.dto;

public class RequestCalculadoraDTO {
    private String nomeCalculadora;

    public RequestCalculadoraDTO(String nomeCalculadora) {
        this.nomeCalculadora = nomeCalculadora;
    }

    public String getNomeCalculadora() {
        return nomeCalculadora;
    }
}
