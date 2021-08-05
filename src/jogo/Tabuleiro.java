package jogo;

import java.util.Random;

public class Tabuleiro {
    private  char simbolo;
    public static char vencedor = ' ';

    public Tabuleiro(){
        this.simbolo = ' ';
    }

    //funcao que coloca um espaco vazio em cada campo do tabuleiro, pegando de Tabuleiro()
    public static void iniciaJogo(Tabuleiro[][] jogo){
        for (int i = 0; i < jogo.length; i++) {
            for (int j = 0; j < jogo.length; j++) {
                jogo[i][j] = new Tabuleiro();
            }
        }
    }

    public char getSimbolo(){ //retornando o simbolo atual
        return this.simbolo;
    }

    //para setar o simbolo que quero colocar no campo e verifica se ha um espaco vazio
    public void setSimbolo( char simbolo){
        if(this.simbolo == ' '){
            this.simbolo = simbolo;
        } else {System.out.println("Campo ja Usado");}
    }
    
    //ver quem comeca usando um random para depois transformar em char sendo 79 =O e 88 = X
    public static char quemComeca(){
        Random random = new Random();
        char valor = (char)(79 + (random.nextInt(2)* 9));
        return valor;
    }

    //funcao para desenhar como estar o jogo e limpar a tela
    public static void desenhaJogo(Tabuleiro[][] jogo){
        limparTela();

        System.out.println("   0    1    2");
        System.out.printf("0   %c | %c | %c %n", jogo[0][0].getSimbolo(), jogo[0][1].getSimbolo(), jogo[0][2].getSimbolo() );
        System.out.println("  -------------");
        System.out.printf("1   %c | %c | %c %n", jogo[1][0].getSimbolo(), jogo[1][1].getSimbolo(), jogo[1][2].getSimbolo() );
        System.out.println("  -------------");
        System.out.printf("2   %c | %c | %c %n", jogo[2][0].getSimbolo(), jogo[2][1].getSimbolo(), jogo[2][2].getSimbolo() );
    }

    //funcao para "limpar"
    public static void limparTela(){
        for (int i = 0; i <20; i++) {
            System.out.println(" ");
        }
    }

    //verifica se o campo esta vazio para colocar o simbolo
    public static  Boolean verificaCampo(Tabuleiro[][] jogo, int[] p, char simboloAtual){
        if(jogo[p[0]][p[1]].getSimbolo()== ' '){

            // se o espaco estiver vazio, pega o simbolo referente a 
            //jpgata atual e coloca na posicao passada
            jogo[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        } else {return false;}
    }
    

    public static void verificaJogo(Tabuleiro[][] jogo){ //verifica se ha ganhadorpegando os simbolos de cada linha e vendo se sao iguais

        //testando linha 
        for (int linha = 0; linha < 3; linha++) {
            if ((jogo[linha][0].getSimbolo() == jogo[linha][1].getSimbolo()) 
            && (jogo[linha][0].getSimbolo() == jogo[linha][2].getSimbolo()) 
            && (jogo[linha][0].getSimbolo() != ' ')) {

                vencedor = jogo[linha][0].getSimbolo();
                break;
               
            }
        }
        //verifica coluna
        for (int coluna = 0; coluna < 3; coluna++) {
            if ((jogo[0][coluna].getSimbolo() == jogo[1][coluna].getSimbolo()) 
            && (jogo[0][coluna].getSimbolo() == jogo[2][coluna].getSimbolo()) 
            && (jogo[0][coluna].getSimbolo() != ' ')) {

                 vencedor = jogo[coluna][0].getSimbolo();
                 break;
                 
                
            }
        }
        //verifica linhas cruzadas
        if ((jogo[0][0].getSimbolo() == jogo[1][1].getSimbolo()) 
            && (jogo[0][0].getSimbolo() == jogo[2][2].getSimbolo()) 
            && (jogo[0][0].getSimbolo() != ' ')) {
                vencedor = jogo[0][0].getSimbolo();
            } else 
            if ((jogo[0][2].getSimbolo() == jogo[1][1].getSimbolo()) 
                && (jogo[0][2].getSimbolo() == jogo[2][0].getSimbolo()) 
                && (jogo[0][2].getSimbolo() != ' ')) {
                vencedor = jogo[0][2].getSimbolo();
            }
    }
}

