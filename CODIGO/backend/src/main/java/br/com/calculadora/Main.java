package br.com.calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        while (true) {
            System.out.println("Digite 2 numeros: ");
            int n1 = ler.nextInt();
            int n2 = ler.nextInt();

            if (n1 < 0 || n2 < 0) {
                System.out.println("Nao pode numero negativo");
                continue;
            }

            Calculadora calc = new Calculadora(n1, n2);

            System.out.println("Calculadora:");
            System.out.println("1 - Soma | 2 - Subtracao | 3 - Multiplicacao | 4 - Divisao ");
            int op = ler.nextInt();

            switch (op) {
                case 1:
                    System.out.println("A soma dos 2 numeros eh: " + calc.somar());
                    break;
                case 2:
                    System.out.println("A subtracao dos 2 numeros eh: " + calc.subtrair());
                    break;
                case 3:
                    System.out.println("A multiplicacao dos 2 numeros eh: " + calc.multiplicar());
                    break;
                case 4:
                    try {
                        System.out.println("A divisao dos 2 numeros eh: " + calc.dividir());
                    } catch (ArithmeticException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Digito invalido");
            }
        }
    }
}
