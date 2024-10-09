package br.ifes.projsist.calculadora.model.loader;

import br.ifes.projsist.calculadora.model.calculadora.ICalculadora;

public class CalculadoraLoader extends AbstractLoader<ICalculadora> {
    public CalculadoraLoader() {
        this.pacoteBase = this.pacoteBase + "calculadora.";
    }
}
