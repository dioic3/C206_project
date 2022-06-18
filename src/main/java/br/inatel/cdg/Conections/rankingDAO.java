package br.inatel.cdg.Conections;

import br.inatel.cdg.models.Jogador;
import br.inatel.cdg.models.Rank;
import br.inatel.cdg.models.Ranking;
import br.inatel.cdg.models.RankingJogadorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class rankingDAO extends connectionDAO{
    boolean sucesso = false;

    public boolean inserirRanking(RankingJogadorDTO jogadorDTO) {
        connectToDB();
        String sql = "INSERT INTO ranking (idjogador, tempo) values(?,?)";

        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, jogadorDTO.getJogador().getId());
            pst.setLong(2, jogadorDTO.getRank().getTempo());
            pst.execute();
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            sucesso = true;
            jogadorDTO.getRank().setId(rs.getInt(1)); //jogador retorna com o ID
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

    public Ranking recuperaRankOrdenado(){
        connectToDB();
        String sql = "SELECT r.tempo,r.id,j.id,j.nick FROM jogador j INNER JOIN Ranking r ON j.id = r.idjogador";
        Ranking ranking = new Ranking();
        try {
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){

                Rank rank = new Rank();
                rank.setId(rs.getInt(2));
                rank.setTempo(rs.getLong(1));

                Jogador jogador = new Jogador();
                jogador.setId(rs.getInt(3));
                jogador.setNome(rs.getString(4));
                ranking.addJogador(new RankingJogadorDTO(rank,jogador));
            }
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
        return ranking;
    }
}
