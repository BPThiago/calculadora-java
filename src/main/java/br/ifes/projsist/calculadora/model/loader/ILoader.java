package br.ifes.projsist.calculadora.model.loader;

import java.util.Set;

public interface ILoader<T> {
    T criar(String opcao);

    Set<T> acessaClasses();
}
