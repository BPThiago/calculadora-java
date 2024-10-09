package br.ifes.projsist.calculadora.model.calculadora;

import br.ifes.projsist.calculadora.model.dto.RequestOperacaoDTO;
import br.ifes.projsist.calculadora.model.dto.ResponseOperacaoDTO;
import br.ifes.projsist.calculadora.model.exception.DivisaoPorZeroException;
import br.ifes.projsist.calculadora.model.exception.OperacaoInvalidaException;

import java.util.Map;

public interface ICalculadora {
    ResponseOperacaoDTO calcular(RequestOperacaoDTO requestDTO) throws OperacaoInvalidaException, DivisaoPorZeroException;

    Map<String, String> getOperacoesDisponiveis();

    String getNome();

    String getIdentificador();
}
