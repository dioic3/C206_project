package br.inatel.cdg.Conections;
import br.inatel.cdg.models.Jogador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jogadorDAO extends connectionDAO {
    boolean sucesso = false;

    public boolean inserirJogador(Jogador jogador) {
        connectToDB();
        String sql = "INSERT INTO jogador (nick) values(?)";

        try {

            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, jogador.getNome());
            pst.execute();
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            sucesso = true;
            jogador.setId(rs.getInt(1)); //jogador retorna com o ID
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            exc.printStackTrace();
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
    public boolean atualizarJogador(int id, Jogador jogador) {
        connectToDB();
        String sql = "UPDATE jogador SET nick=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.getNome());
            pst.setInt(2, id);
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
    public Jogador recuperaJogadorPeloNome(String nome){
        connectToDB();
        String sql = "SELECT ID,NICK FROM jogador where nick=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Jogador jogador = new Jogador();
                jogador.setId(rs.getInt(1));
                jogador.setNome(rs.getString(2));
                return jogador;
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
        return null;
    }
}
