package br.ifes.projsist.calculadora.model.exception;

public class DivisaoPorZeroException extends ArithmeticException {
    public DivisaoPorZeroException(String msg) {
        super(msg);
    }
}
