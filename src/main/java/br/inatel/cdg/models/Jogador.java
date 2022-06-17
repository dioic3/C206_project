package br.inatel.cdg.models;

public class Jogador implements Comparable<Jogador>{
    private static String nick;
    private static long tempogasto;


    public String getNome() {
        return nick;
    }

    public void setNome(String nick) {
        this.nick = nick;
    }

    public long getTempogasto() {
        return tempogasto;
    }

    public void setTempogasto(long tempogasto) {
        this.tempogasto = tempogasto;
    }

    @Override
    public int compareTo(Jogador jogador) {
        if (this.getTempogasto() < jogador.getTempogasto()) {
            return -1;
        }
        if (this.getTempogasto() > jogador.getTempogasto()) {
            return 1;
        }
        return 0;
    }
}