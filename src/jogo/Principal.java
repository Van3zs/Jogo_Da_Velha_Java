package jogo;


import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Tabuleiro[][] tabuleiro = new Tabuleiro[3][3];
        char quemComeca;
        char vencedor;


        Scanner entrada = new Scanner(System.in);

        System.out.println("BEM VINDO AO JOGO DA VELHA");
        System.out.println("Qual o seu nome? e o level");
        String nome = entrada.nextLine();
        int level = entrada.nextInt();

        quemComeca = Tabuleiro.quemComeca();
        if(quemComeca == 'X'){
            System.out.printf("AAARG!! Voce comeca HUMANO %s :/", nome);
        }else{System.out.println("AAAAAH EU COMECO HUMANO!");}

        Tabuleiro.iniciaJogo(tabuleiro); //chamando a funcao que coloca espacos vazios no tabuleiro

        //usando um for para rodar enquanto durar as partidas
         for (int i = 0; i < 9; i++) {
            
            if(quemComeca == 'X'){
                Jogador.jogadaHumano(entrada,tabuleiro);
                quemComeca ='O';
            } else {
                Computador.jogadaComp(entrada,tabuleiro,level);
                quemComeca = 'X';
            }

            Tabuleiro.desenhaJogo(tabuleiro);
            Tabuleiro.verificaJogo(tabuleiro); // verifica se alguem ganhou
            vencedor = Tabuleiro.vencedor;

            if(vencedor != ' '){
                System.out.printf("O ganhador foi %c \n", vencedor);
                break;
            }else if(i == 8){System.out.println("EMPATE!");} //diz se houve um empate se terminar a partida e ninguem tiver ganhado
            
         } 

         
         System.out.println("Fim do Jogo");
    }


}
