package br.ifes.projsist.calculadora.model.operacao;

public class Soma implements IOperacaoBasica {
    @Override
    public int calcular(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public String getOperador() {
        return "+";
    }

    @Override
    public String getNome() {
        return "Soma";
    }
}
