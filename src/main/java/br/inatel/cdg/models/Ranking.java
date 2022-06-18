package br.inatel.cdg.models;

import br.inatel.cdg.models.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private List<Jogador> rank;

    public Ranking(){
        rank = new ArrayList<>();
    }
    public void addJogador(Jogador j){
        rank.add(j);
        rank.sort((jogador1 , jogador2)-> jogador1.compareTo(jogador2));

    }
    public int VerPosicao(Jogador j1){
        return rank.indexOf(j1) + 1;
    }
    public void mostrarRank(){
        rank.forEach((jogador)-> System.out.println("Rank: " + this.VerPosicao(jogador) + "º Jogador:" + jogador.getNome() + " - com o TEMPO de: " + jogador.getTempogasto()) );
    }
}