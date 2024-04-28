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
class Jogo {

    private Jogador jogador1;
    private Jogador jogador2;
    private char[][] tabuleiro;
    private boolean turnoJogador1;

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = new char[3][3];
        this.turnoJogador1 = true;
        inicializarTabuleiro();

    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private boolean casaVazia(int linha, int coluna) {
        return tabuleiro[linha][coluna] == ' ';
    }

    public void jogar() {
        Jogador JogadorAtual = jogador1;
        while (!FimDeJogo()) {
            exibirTabuleiroAtual();
            fazerJogada(JogadorAtual);
            if (turnoJogador1) {
                turnoJogador1 = false;
                JogadorAtual = jogador2;
            }
        }
    }

    private boolean FimDeJogo() {
        if (verificarVitoria(jogador1.getCaracter())) {
            System.out.println("Jogador 1 venceu!");
            return true;
        } else if (verificarVitoria(jogador2.getCaracter())) {
            System.out.println("Jogador 2 venceu!");
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
        if (JogadorAtual == jogador1) {
            atual = 1;
        } else {
            atual = 2;
        }
        System.out.println("Jogador" + atual + " digite a linha: ");
        int JogadaL = Teclado.nextInt();
        if (JogadaL < 0 || JogadaL >= 3) {
            System.out.println("opcao invalida, jogue novamente");
            fazerJogada(JogadorAtual);
        }
        System.out.println("Jogador" + atual + " digite a coluna: ");
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
