package br.inatel.cdg.Conections;

import br.inatel.cdg.models.Jogador;
import br.inatel.cdg.models.Rank;

import java.sql.SQLException;

public class rankingDAO extends connectionDAO{
    boolean sucesso = false;

    public boolean inserirRanking(Jogador jogador) {
        connectToDB();
        String sql = "INSERT INTO ranking (idjogador, tempo) values(?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, jogador.getId());
            pst.setLong(2, jogador.getTempogasto());
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    public boolean atualizarRanking(Rank rank) {
        connectToDB();
        String sql = "UPDATE ranking SET idjogador=?, tempo=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, rank.getJogador().getId());
            pst.setLong(2, rank.getJogador().getTempogasto());
            pst.setInt(3, rank.getId());
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    public boolean deletarJogador(int id) {
        connectToDB();
        String sql = "DELETE FROM jogador where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}
