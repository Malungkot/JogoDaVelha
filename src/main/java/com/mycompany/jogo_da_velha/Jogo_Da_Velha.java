/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jogo_da_velha;

import java.util.Scanner;

/**
 *
 * @author augus
 */
public class Jogo_Da_Velha {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem-vindo ao Jogo da Velha!");
        System.out.println("Digite '1', para poder jogar contra outro jogador ou digite qualquer outro numero interio para jogar contra um bot");
        int escolha = teclado.nextInt();

        if (escolha == 1) {
            Jogador Jogador1 = new Jogador();
            Jogador Jogador2 = new Jogador();
            System.out.println("Jogador 1: digite um caracter: ");
            char caracter1 = teclado.next().charAt(0);
            Jogador1.setCaracter(caracter1);
            System.out.println("Jogador 2: digite um caracter: ");
            char caracter2 = teclado.next().charAt(0);
            if (caracter1 != caracter2) {
                Jogador2.setCaracter(caracter2);
            } else {
                System.out.println("caracteres iguais, digite outro");
                int repetido = 1;
                while (repetido == 1) {
                    caracter2 = teclado.next().charAt(0);
                    if (Jogador1.getCaracter() != caracter2) {
                        Jogador2.setCaracter(caracter2);
                        repetido = 0;
                    }
                }

                Jogo NovoJogo = new Jogo(Jogador1, Jogador2);
                NovoJogo.jogar();
            }
        } else{
            Jogador Jogador1 = new Jogador();
            Bot bot = new Bot();
            System.out.println("Jogador 1: digite um caracter: ");
            char caracter = teclado.next().charAt(0);
            Jogador1.setCaracter(caracter);
            if (caracter == 'X' || caracter == 'x' ) {
                caracter = 'O';
                bot.setCaracter(caracter);
            } else {
                caracter = 'X';
                bot.setCaracter(caracter);
            }
            JogoBot NovoJogo = new JogoBot(Jogador1, bot);
            NovoJogo.jogar();
        }

        }
}
