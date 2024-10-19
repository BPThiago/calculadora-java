package br.ifes.projsist.calculadora.view;

import java.util.Map;
import java.util.Scanner;

import br.ifes.projsist.calculadora.controller.ControllerCalculadora;
import br.ifes.projsist.calculadora.model.dto.RequestCalculadoraDTO;
import br.ifes.projsist.calculadora.model.dto.RequestOperacaoDTO;
import br.ifes.projsist.calculadora.model.dto.ResponseOperacaoDTO;

public class Menu {
    public static RequestCalculadoraDTO escolherCalculadora() {
        Scanner s = new Scanner(System.in);

        System.out.println("Escolha a calculadora que deseja usar:");

        Map<String, String> calculadorasMap = ControllerCalculadora.getCalculadorasDisponiveis();

        for (String cod : calculadorasMap.keySet())
            System.out.println("(" + cod + ") " + calculadorasMap.get(cod));

        System.out.print("Escolha: ");
        return new RequestCalculadoraDTO(s.next());
    }

    public static RequestOperacaoDTO interagir(ControllerCalculadora controller) {
        System.out.println("*** CALCULADORA ***");

        Scanner s = new Scanner(System.in);

        System.out.print("Insira o primeiro número: ");
        int num1 = s.nextInt();

        Map<String, String> operacoes = controller.getOperacoesDisponiveis();
        System.out.println("Insira o operador para o cálculo");
        for (String op : operacoes.keySet())
            System.out.println("(" + op + ") " + operacoes.get(op));
        System.out.print("Operador: ");
        String operador = s.next();

        System.out.print("Insira o segundo número: ");
        int num2 = s.nextInt();

        return new RequestOperacaoDTO(num1, operador, num2);
    }

    public static void exibirResultado(ResponseOperacaoDTO responseDTO) {
        System.out.println("O resultado da operação é: " + responseDTO.getResult());
    }
}
