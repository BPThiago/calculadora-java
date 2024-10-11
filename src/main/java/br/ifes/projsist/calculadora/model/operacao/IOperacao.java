package br.ifes.projsist.calculadora.model.operacao;

public interface IOperacao {
    int calcular(int num1, int num2) throws ArithmeticException;

    String getOperador();

    String getNome();
}
