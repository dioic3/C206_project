package br.inatel.cdg.models;

import br.inatel.cdg.models.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private List<RankingJogadorDTO> rank;

    public Ranking(){
        rank = new ArrayList<>();
    }
    public void addJogador(RankingJogadorDTO j){
        rank.add(j);
        ordenaRank();


    }
    public int VerPosicao(RankingJogadorDTO j1){
        return rank.indexOf(j1) + 1;
    }
    public void mostrarRank(){
        try{
            for(int i =0; i < 5; i++){
                RankingJogadorDTO jogadorDTO = rank.get(i);
                System.out.println((i+1)+"º "+ jogadorDTO.toString());
            }
        }catch (IndexOutOfBoundsException e){

        }

    }
    public void ordenaRank(){
        rank.sort((jogador1 , jogador2)-> jogador1.compareTo(jogador2));
    }
}