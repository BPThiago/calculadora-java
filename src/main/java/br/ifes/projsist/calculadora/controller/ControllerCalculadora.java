package br.ifes.projsist.calculadora.controller;

import br.ifes.projsist.calculadora.model.calculadora.AbstractCalculadora;
import br.ifes.projsist.calculadora.model.calculadora.ICalculadora;
import br.ifes.projsist.calculadora.model.dto.RequestCalculadoraDTO;
import br.ifes.projsist.calculadora.model.dto.RequestOperacaoDTO;
import br.ifes.projsist.calculadora.model.dto.ResponseOperacaoDTO;
import br.ifes.projsist.calculadora.model.exception.*;

import java.util.Map;

public class ControllerCalculadora {
    private ICalculadora calc;

    public ControllerCalculadora(RequestCalculadoraDTO requestCalculadoraDTO) {
        this.calc = AbstractCalculadora.criar(requestCalculadoraDTO.getNomeCalculadora());
    }

    public ResponseOperacaoDTO calcular(RequestOperacaoDTO requestDTO) throws OperacaoInvalidaException, DivisaoPorZeroException {
        return this.calc.calcular(requestDTO);
    }

    public Map<String, String> getOperacoesDisponiveis() {
        return this.calc.getOperacoesDisponiveis();
    }

    public static Map<String, String> getCalculadorasDisponiveis() {
        Map<String, String> calculadorasMap = AbstractCalculadora.getCalculadorasDisponiveis();
        return calculadorasMap;
    }
}
