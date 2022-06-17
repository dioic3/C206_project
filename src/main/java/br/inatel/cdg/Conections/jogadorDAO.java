package br.inatel.cdg.Conections;
import br.inatel.cdg.models.Jogador;
import java.sql.SQLException;

public class jogadorDAO extends connectionDAO {
    boolean sucesso = false;

    public boolean inserirJogador(Jogador jogador) {
        connectToDB();
        String sql = "INSERT INTO jogador (nick, tempo) values(?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.getNome());
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
    public boolean atualizarJogador(int id, Jogador jogador) {
        connectToDB();
        String sql = "UPDATE jogador SET nick=?, tempo=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.getNome());
            pst.setLong(2, jogador.getTempogasto());
            pst.setInt(3, id);
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
