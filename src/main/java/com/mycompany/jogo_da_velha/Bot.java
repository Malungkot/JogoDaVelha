/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo_da_velha;

import java.util.Random;

/**
 *
 * @author augus
 */
class Bot {

    private char Caracter;
    private Random random;

    public void setCaracter(char Caracter) {
        this.Caracter = Caracter;
        this.random = new Random();
    }
    public char getCaracter() {
        return Caracter;
    }
    public int[] fazerJogada(char[][] tabuleiro) {
        int linha, coluna;
        do {
            linha = random.nextInt(3);
            coluna = random.nextInt(3);
        } while (tabuleiro[linha][coluna] != ' ');
        return new int[] {linha, coluna};
        }

    
}
