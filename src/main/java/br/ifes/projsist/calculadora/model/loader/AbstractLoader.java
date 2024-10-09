package br.ifes.projsist.calculadora.model.loader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractLoader<T> implements ILoader<T> {
    protected String pacoteBase = "br.ifes.projsist.calculadora.model.";

    @Override
    public T criar(String opcao) {
        try {
            Class<?> classe = Class.forName(this.pacoteBase + opcao);
            return (T) classe.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | NoSuchMethodException |
                InvocationTargetException e) {
            return null;
        }
    }

    @Override
    public Set<T> acessaClasses() {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(this.pacoteBase.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> this.criar(line.substring(0, line.lastIndexOf('.'))))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
}
