package br.ifes.projsist.calculadora.model.calculadora;

import br.ifes.projsist.calculadora.model.exception.OperacaoInvalidaException;
import br.ifes.projsist.calculadora.model.loader.ILoader;
import br.ifes.projsist.calculadora.model.loader.OperacaoLoader;
import br.ifes.projsist.calculadora.model.operacao.IOperacao;

import java.util.*;

public class CalculadoraCientifica extends AbstractCalculadora {
    ILoader<IOperacao> operacaoLoader;
    private Map<String, String> operacoesMap;
    private Set<IOperacao> operacoes;

    public CalculadoraCientifica() {
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
            this.operacoes.add(op);
            this.operacoesMap.put(op.getOperador(), op.getNome());
        }
    }

    public Map<String, String> getOperacoesDisponiveis() {
        return operacoesMap;
    }

    public String getNome() {
        return "Calculadora Científica";
    }

    public String getIdentificador() {
        return "c";
    }
}
