package br.ifes.projsist.calculadora.model.operacao;

import br.ifes.projsist.calculadora.model.exception.DivisaoPorZeroException;

public class Divisao implements IOperacaoBasica {
    @Override
    public int calcular(int num1, int num2) throws DivisaoPorZeroException {
        if (num2 == 0)
            throw new DivisaoPorZeroException("Erro: Divisor deve ser diferente de zero!");
        return num1 / num2;
    }

    @Override
    public String getOperador() {
        return "/";
    }

    @Override
    public String getNome() {
        return "Divisão";
    }
}
