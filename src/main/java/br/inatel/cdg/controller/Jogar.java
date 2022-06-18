package br.inatel.cdg.controller;

import br.inatel.cdg.Conections.jogadorDAO;
import br.inatel.cdg.models.*;
import br.inatel.cdg.Conections.rankingDAO;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jogar {
    public static void main() {
        //Variables
        Scanner sc = new Scanner(System.in);
        String passoatual;
        long tempoInicial;
        long tempoFinal;
        long tempoGasto;

        String passoanterior;
        rankingDAO rankingBD = new rankingDAO();
        Ranking ranking = rankingBD.recuperaRankOrdenado();

        jogadorDAO jogadorBD = new jogadorDAO();
        String jogarnovamente;


        passoanterior = "x";

        System.out.println("Digite seu nick: ");
        String nome = sc.nextLine();
        Jogador j1 =  jogadorBD.recuperaJogadorPeloNome(nome); // recupera jogador do BD
        if(j1 == null){
            j1 = new Jogador();
            j1.setNome(nome);
            jogadorBD.inserirJogador(j1);
        }
        System.out.println("O jogo vai começar em ");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(" 3 ");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(" 2 ");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(" 1 ");

            TimeUnit.SECONDS.sleep(1);
            System.out.println(" VAI VAI VAI! ");
            // COMEÇA O JOGO
            tempoInicial = System.currentTimeMillis();
            Move move = null;
            Move lastMove = null;
            for(int passos =1;passos<=10; passos++) {
                move = Move.getUserInput(lastMove);
                System.out.println("Passo atual: " + passos);
                lastMove = move;
            }
            System.out.println("FIM DA CORRIDA! ESTAMOS CALCULANDO SEU TEMPO...");
            TimeUnit.SECONDS.sleep(4);
            tempoFinal = System.currentTimeMillis();
            tempoGasto = tempoFinal - tempoInicial;
            System.out.println("Seu tempo foi: " + tempoGasto + "ms.");
            Rank rank = new Rank();
            rank.setTempo(tempoGasto);
            rank.setJogador(j1);
            RankingJogadorDTO jogadorDTO = new RankingJogadorDTO(rank,j1);
            ranking.addJogador(jogadorDTO);
            System.out.println("Sua posiçao no ranking é: " + ranking.VerPosicao(jogadorDTO));// implementaar retorno do rank
            rankingBD.inserirRanking(jogadorDTO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("JOGAR NOVAMENTE? SIM//NAO ");
        jogarnovamente = sc.nextLine();


    }



}