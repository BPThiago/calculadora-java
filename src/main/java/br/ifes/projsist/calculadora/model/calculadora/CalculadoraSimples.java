package br.ifes.projsist.calculadora.model.calculadora;

import br.ifes.projsist.calculadora.model.dto.RequestOperacaoDTO;
import br.ifes.projsist.calculadora.model.dto.ResponseOperacaoDTO;
import br.ifes.projsist.calculadora.model.exception.DivisaoPorZeroException;
import br.ifes.projsist.calculadora.model.exception.OperacaoInvalidaException;
import br.ifes.projsist.calculadora.model.loader.ILoader;
import br.ifes.projsist.calculadora.model.loader.OperacaoLoader;
import br.ifes.projsist.calculadora.model.operacao.IOperacao;
import br.ifes.projsist.calculadora.model.operacao.IOperacaoBasica;

import java.util.*;

public class CalculadoraSimples extends AbstractCalculadora {
    ILoader<IOperacao> operacaoLoader;
    private Map<String, String> operacoesMap;
    private Set<IOperacaoBasica> operacoes;

    public CalculadoraSimples() {
        this.operacaoLoader = new OperacaoLoader();
        this.operacoes = new HashSet<>();
        this.operacoesMap = new HashMap<>();
        fillOperacoes();
    }

    @Override
    protected IOperacao mapOperacao(String opcao) throws OperacaoInvalidaException {
        for (IOperacao op : operacoes)
            if (op.getOperador().equals(opcao))
                return op;
        throw new OperacaoInvalidaException("Erro: Operação não implementada!");
    }

    private void fillOperacoes() {
        Set<IOperacao> allOperacoes = this.operacaoLoader.acessaClasses();
        for (IOperacao op : allOperacoes) {
            if (op instanceof IOperacaoBasica) {
                this.operacoes.add((IOperacaoBasica) op);
                this.operacoesMap.put(op.getOperador(), op.getNome());
            }
        }
    }

    public Map<String, String> getOperacoesDisponiveis() {
        return operacoesMap;
    }

    public String getNome() {
        return "Calculadora Simples";
    };

    public String getIdentificador() {
        return "s";
    }
}