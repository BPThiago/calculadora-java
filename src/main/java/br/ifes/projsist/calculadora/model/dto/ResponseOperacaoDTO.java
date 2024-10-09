package br.ifes.projsist.calculadora.model.dto;

public class ResponseOperacaoDTO {
    private int result;
    public ResponseOperacaoDTO(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
