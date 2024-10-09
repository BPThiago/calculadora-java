package br.ifes.projsist.calculadora.model.exception;

public class OperacaoInvalidaException extends IllegalArgumentException {
    public OperacaoInvalidaException(String msg) {
        super(msg);
    }
}
