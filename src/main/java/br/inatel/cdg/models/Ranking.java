package br.inatel.cdg.models;

import br.inatel.cdg.models.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private List<Jogador> rank;

    public Ranking(){
        rank = new ArrayList<>(); //TODO --ORDENAR ARRAY
    }
    public void addJogador(Jogador j){
        rank.add(j);
    }
    public int VerPosicao(Jogador j1){
        return rank.indexOf(j1) + 1;
    }
    public void mostrarRank(){

    }
}