package br.ifes.projsist.calculadora.application;

import br.ifes.projsist.calculadora.controller.ControllerCalculadora;
import br.ifes.projsist.calculadora.model.dto.RequestCalculadoraDTO;
import br.ifes.projsist.calculadora.model.dto.RequestOperacaoDTO;
import br.ifes.projsist.calculadora.model.dto.ResponseOperacaoDTO;
import br.ifes.projsist.calculadora.model.exception.CalculadoraInvalidaException;
import br.ifes.projsist.calculadora.model.exception.DivisaoPorZeroException;
import br.ifes.projsist.calculadora.model.exception.OperacaoInvalidaException;
import br.ifes.projsist.calculadora.view.Menu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            RequestCalculadoraDTO requestCalculadoraDTO = Menu.escolherCalculadora();
            ControllerCalculadora controller = new ControllerCalculadora(requestCalculadoraDTO);
            RequestOperacaoDTO requestDTO = Menu.interagir(controller);
            ResponseOperacaoDTO responseDTO = controller.calcular(requestDTO);
            Menu.exibirResultado(responseDTO);
        } catch (OperacaoInvalidaException | DivisaoPorZeroException | CalculadoraInvalidaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Rapaz.. reinicia o computador e vê se funciona.");
        }
    }
}
