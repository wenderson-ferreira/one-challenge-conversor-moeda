package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int opc = 0;
        Scanner scan = new Scanner(System.in);

        while (opc != 7) {
            menu();
            opc = scan.nextInt();
            execute(opc, scan);
        }

    }

    static void menu(){
        String  opcMenu = """
                ###################################################3
                Seja bem vindo/a ao Converspr de Moeda =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileiro
                4) Real brasileiro =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Sair
                Escolha uma opção válida:
                ###################################################3
                """;
        System.out.println(opcMenu);
    }

    static void execute(int opc, Scanner scan){
        String msgValue = "Digite o valor que deseja converter: ";
        double valor = 0.0;

        switch (opc){
            case 1:
                System.out.println(msgValue);
                valor = scan.nextDouble();
                ExchangeRateAPIHelper.convert("USD","ARS", valor);
                break;
            case 2:
                System.out.println(msgValue);
                valor = scan.nextDouble();
                ExchangeRateAPIHelper.convert("ARS","USD", valor);
                break;
            case 3:
                System.out.println(msgValue);
                valor = scan.nextDouble();
                ExchangeRateAPIHelper.convert("USD","BRL", valor);
                break;
            case 4:
                System.out.println(msgValue);
                valor = scan.nextDouble();
                ExchangeRateAPIHelper.convert("BRL","USD", valor);
                break;
            case 5:
                System.out.println(msgValue);
                valor = scan.nextDouble();
                ExchangeRateAPIHelper.convert("USD","COP", valor);
                break;
            case 6:
                System.out.println(msgValue);
                valor = scan.nextDouble();
                ExchangeRateAPIHelper.convert("COP","USD", valor);
                break;
            case 7:
               System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}