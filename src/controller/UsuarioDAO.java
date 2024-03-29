package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioDAO {

    Connection conexao = null;
    PreparedStatement ps;
    ResultSet rs;

    String consultarUsuario = "select * from tbusuarios where iduser=?";

    public Usuario consultarUsuairo(int id) {
        try {
            conexao = ModuloConexao.conectar();
            ps = conexao.prepareStatement(consultarUsuario);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            Usuario obj = new Usuario();

            if (rs.next()) {
                obj.setId(rs.getInt(id));
                obj.setNome(rs.getString("nome"));
                obj.setFone(rs.getString(3));
                obj.setLogin(rs.getString(4));
                obj.setSenha(rs.getString(5));
                obj.setPerfil(rs.getString(6));
            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            return null;
        }
    }
}
