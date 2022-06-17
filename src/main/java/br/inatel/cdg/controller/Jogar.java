package br.inatel.cdg.controller;

import br.inatel.cdg.Conections.jogadorDAO;
import br.inatel.cdg.models.Jogador;
import br.inatel.cdg.models.Ranking;

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
        int passos = 0;
        String passoanterior;
        Ranking ranking = new Ranking();
        jogadorDAO jogadorBD = new jogadorDAO();
        String jogarnovamente;

        sc.nextLine();
        passoanterior = "x";

        Jogador j1 = new Jogador();
        System.out.println("Digite seu nick: ");
        j1.setNome(sc.nextLine());

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
            passoatual = sc.nextLine();

            while (passos < 10) {
                passoatual = sc.nextLine();
                if (!passoatual.equals(passoanterior)) {
                    passos++;
                    System.out.println("PASSOS DADOS " + passos);

                } else if (passoatual.equals(passoanterior)) {
                    System.out.println("Ops, quase tropecou"); //Substituir por "Ops, quase tropeceu" ou "perdeu o pé".
                    System.out.println("LEMBRE-SE SEMPRE DE USAR O OUTRO PÉ");
                }
                passoanterior = passoatual;
            }
            System.out.println("FIM DA CORRIDA! ESTAMOS CALCULANDO SEU TEMPO...");
            TimeUnit.SECONDS.sleep(4);
            tempoFinal = System.currentTimeMillis();
            tempoGasto = tempoFinal - tempoInicial;
            pos_jogo:
            System.out.println("Seu tempo foi: " + tempoGasto + "ms.");
            j1.setTempogasto(tempoGasto);
            ranking.addJogador(j1);
            System.out.println("Sua posiçao no ranking é: " + ranking.VerPosicao(j1));// implementaar retorno do rank
            jogadorBD.inserirJogador(j1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("JOGAR NOVAMENTE? SIM//NAO ");
        jogarnovamente = sc.nextLine();
    }

}