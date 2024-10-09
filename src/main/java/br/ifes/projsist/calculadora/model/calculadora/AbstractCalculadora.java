package br.ifes.projsist.calculadora.model.calculadora;

import br.ifes.projsist.calculadora.model.dto.RequestOperacaoDTO;
import br.ifes.projsist.calculadora.model.dto.ResponseOperacaoDTO;
import br.ifes.projsist.calculadora.model.exception.CalculadoraInvalidaException;
import br.ifes.projsist.calculadora.model.exception.DivisaoPorZeroException;
import br.ifes.projsist.calculadora.model.exception.OperacaoInvalidaException;
import br.ifes.projsist.calculadora.model.loader.CalculadoraLoader;
import br.ifes.projsist.calculadora.model.loader.ILoader;
import br.ifes.projsist.calculadora.model.operacao.IOperacao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractCalculadora implements ICalculadora {
    public ResponseOperacaoDTO calcular(RequestOperacaoDTO requestDTO) throws OperacaoInvalidaException, DivisaoPorZeroException {
        IOperacao operacao = mapOperacao(requestDTO.getOpcao());
        if (operacao == null)
            throw new OperacaoInvalidaException("Erro: Carregamento de operação não foi concluído");

        int num1 = requestDTO.getNum1();
        int num2 = requestDTO.getNum2();
        int result = operacao.calcular(num1, num2);
        return new ResponseOperacaoDTO(result);
    }

    public static Map<String, String> getCalculadorasDisponiveis() {
        ILoader<ICalculadora> loader = new CalculadoraLoader();

        Set<ICalculadora> calcs = loader.acessaClasses();
        HashMap<String, String> disp = new HashMap<>();

        for (ICalculadora calc : calcs)
            disp.put(calc.getIdentificador(), calc.getNome());
        return disp;
    }

    public static ICalculadora criar(String idCalc) throws CalculadoraInvalidaException {
        ILoader<ICalculadora> loader = new CalculadoraLoader();

        Set<ICalculadora> calcs = loader.acessaClasses();

        for (ICalculadora calc : calcs)
            if (calc.getIdentificador().equals(idCalc))
                return calc;
        throw new CalculadoraInvalidaException("Erro: Calculadora escolhida é inválida!");
    }

    protected abstract IOperacao mapOperacao(String opcao) throws OperacaoInvalidaException;
}
