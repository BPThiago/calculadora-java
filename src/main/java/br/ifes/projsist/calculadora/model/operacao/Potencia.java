package br.ifes.projsist.calculadora.model.operacao;

public class Potencia implements IOperacaoAvancada {
    @Override
    public int calcular(int num1, int num2) {
        return (int) Math.pow(num1, num2);
    }

    @Override
    public String getOperador() {
        return "^";
    }

    @Override
    public String getNome() {
        return "Potência";
    }
}
