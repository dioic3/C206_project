package br.inatel.cdg.models;

public class RankingJogadorDTO implements Comparable<RankingJogadorDTO>{
    private Rank rank;
    private Jogador jogador;

    public RankingJogadorDTO(Rank rank, Jogador jogador) {
        this.rank = rank;
        this.jogador = jogador;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public int compareTo(RankingJogadorDTO o) {
        if (rank.getTempo() < o.getRank().getTempo()) {
            return -1;
        }
        if (rank.getTempo() > o.getRank().getTempo()) {
            return 1;
        }
        return 0;

    }

    @Override
    public String toString() {
        //como vai aparecer na tela os usuarios
        //1º Nome do jogador - Tempo: 1000
        return jogador.getNome() + " - Tempo: "+ rank.getTempo() + "ms.";
    }
}
