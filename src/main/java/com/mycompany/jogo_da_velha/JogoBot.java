/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo_da_velha;

import java.util.Scanner;

/**
 *
 * @author augus
 */
class JogoBot {

    private Jogador Jogador1;
    private Bot bot;
    private char[][] tabuleiro;

    public JogoBot(Jogador Jogador1, Bot bot) {
        this.Jogador1 = Jogador1;
        this.bot = bot;
        this.tabuleiro = new char[3][3];
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    void jogar() {
        while (!FimDeJogo()) {
            exibirTabuleiroAtual();
            fazerJogada(Jogador1);
            exibirTabuleiroAtual();
            int[] jogada = bot.fazerJogada(tabuleiro);
            int linha = jogada[0];
            int coluna = jogada[1];
            if (FimDeJogo()) {
                break;
            }
            System.out.println("bot fez a jogada. linha: " + linha + " coluna: " + coluna);
            tabuleiro[linha][coluna] = bot.getCaracter();
        }
    }

    private boolean FimDeJogo() {
        if (verificarVitoria(Jogador1.getCaracter())) {
            System.out.println("Jogador 1 venceu!");
            return true;
        } else if (verificarVitoria(bot.getCaracter())) {
            System.out.println("Bot venceu!");
            return true;
        } else if (verificarEmpate()) {
            System.out.println("Empate!");
            return true;
        }
        return false;
    }

    private boolean verificarVitoria(char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == simbolo && tabuleiro[1][j] == simbolo && tabuleiro[2][j] == simbolo) {
                return true;
            }
        }
        if ((tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) || (tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo)) {
            return true;
        }
        return false;
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void exibirTabuleiroAtual() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            for (int x = 0; x < 13; x++) {
                if (i < 2) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    private void fazerJogada(Jogador JogadorAtual) {
        Scanner Teclado = new Scanner(System.in);
        int atual = 0;
        System.out.println("Jogador 1" + " digite a linha: ");
        int JogadaL = Teclado.nextInt();
        if (JogadaL < 0 || JogadaL >= 3) {
            System.out.println("opcao invalida, jogue novamente");
            fazerJogada(JogadorAtual);
        }
        System.out.println("Jogador 1" + " digite a coluna: ");
        int JogadaC = Teclado.nextInt();
        if (JogadaC < 0 || JogadaC >= 3) {
            System.out.println("opcao invalida, jogue novamente");
            fazerJogada(JogadorAtual);
        }
        if (tabuleiro[JogadaL][JogadaC] != ' ') {
            System.out.println("lugar ocupado, jogue novamene");
            fazerJogada(JogadorAtual);
        } else {
            tabuleiro[JogadaL][JogadaC] = JogadorAtual.getCaracter();
        }
    }
}
