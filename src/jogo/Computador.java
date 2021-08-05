package jogo;

import java.util.Scanner;

public class Computador {
    static int[] p = new int[2];
    
    public static int[] jogadaComp(Scanner entrada, Tabuleiro[][] jogo, int level){
        boolean valor = true;

        switch(level){
            //comeca pela posicao 0x0 e segue uma linha reta
            case 1:
           preencheNormal(jogo);
            return p;

            case 2:
            int a = 2;
            //preenche de dois em dois(as bordas)
            for (int i = 2; i >=0; i--) {
                p[0] = i;
                p[1]= a;
                a--;
                if(Tabuleiro.verificaCampo(jogo, p, 'O')){
                    valor = false;
                    break;
                }
            }
            // se tudo ja tiver sido preenchido, pega os outros espacos
            if(valor){
               preencheNormal(jogo);
            }
            return p;

            
            default:
            //comeca pelo centro
                p[0] = 1;
                p[1] = 1;
            if(Tabuleiro.verificaCampo(jogo, p, 'O')){
                return p;
            }

            loop:
            //se o centro ja tiver sido escolhido, vai para 0 0, 0 2, 2 0 e 2 2 (pontas extremas) 
            for (int i = 0; i <3 ; i+=2) {
                for (int j = 0; j <3; j+=2) {

                    p[0] = i;
                    p[1]= j;
    
                    if(Tabuleiro.verificaCampo(jogo, p, 'O')){
                        valor =false;
                        break loop;
                    }
                    
                }
            }
            //preenche os outros espacos
            if (valor) {
               preencheNormal(jogo);
                return p;
                
            } else {return p;}
        }
    }
    
    public static void preencheNormal(Tabuleiro[][] jogo){
        loop:
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3; j++) {

                p[0] = i;
                p[1]= j;

                if(Tabuleiro.verificaCampo(jogo, p, 'O')){
                    break loop;
                }
                
            }
        }
    }
}

            
