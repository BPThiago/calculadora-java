package br.ifes.projsist.calculadora.model.exception;

public class CalculadoraInvalidaException extends IllegalArgumentException {
    public CalculadoraInvalidaException(String msg) {
        super(msg);
    }
}