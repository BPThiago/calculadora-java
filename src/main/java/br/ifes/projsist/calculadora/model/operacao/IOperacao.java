package br.ifes.projsist.calculadora.model.operacao;

public interface IOperacao {
    int calcular(int num1, int num2);

    String getOperador();

    String getNome();
}
