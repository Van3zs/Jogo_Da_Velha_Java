package jogo;

import java.util.Scanner;

public class Jogador {

    public static int[] jogadaHumano(Scanner entrada, Tabuleiro[][] jogo){
        int[] p = new int[2];
        boolean valor = true;
        while(valor == true){
            System.out.println("Qual e a sua linha, humano?");
            p[0] = entrada.nextInt();

            System.out.println("Qual e a sua coluna, humano?");
            p[1] = entrada.nextInt();

            //verifica se o espaco ta disponivel para setar
            if(Tabuleiro.verificaCampo(jogo, p, 'X')){
                valor = false;
            } else {System.out.println("Tente de novo, espaco ocupado.");}
        }
        return p;
    }
}
