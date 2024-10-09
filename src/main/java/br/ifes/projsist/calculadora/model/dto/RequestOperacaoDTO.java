package br.ifes.projsist.calculadora.model.dto;

public class RequestOperacaoDTO {
    private int num1, num2;
    private String opcao;

    public RequestOperacaoDTO(int num1, String opcao, int num2) {
        this.opcao = opcao;
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOpcao() {
        return opcao;
    }
}
