package br.ifes.projsist.calculadora.model.loader;

import br.ifes.projsist.calculadora.model.operacao.IOperacao;

public class OperacaoLoader extends AbstractLoader<IOperacao> {
    public OperacaoLoader() {
        this.pacoteBase = this.pacoteBase + "operacao.";
    }
}
