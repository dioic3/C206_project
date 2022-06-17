
package br.inatel.cdg.models;

public class Maratonista {
    private String peDir =" d ";
    private String peEsq = " a ";
    int QuantidadeDePassos[];



    public String getPeDir() {
        return peDir;
    }

    public void setPeDir(String peDir) {
        this.peDir = peDir;
    }

    public String getPeEsq() {
        return peEsq;
    }

    public void setPeEsq(String peEsq) {
        this.peEsq = peEsq;
    }

    public int[] getQuantidadeDePassos() {
        return QuantidadeDePassos;
    }

    public void setQuantidadeDePassos(int[] quantidadeDePassos) {
        QuantidadeDePassos = quantidadeDePassos;
    }
}