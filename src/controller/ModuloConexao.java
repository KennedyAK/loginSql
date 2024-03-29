package controller;

import java.sql.*;

public class ModuloConexao {
    
//      Método responsável pela conexão com o banco
//      @return conexao;

    public static Connection conectar() {
        Connection conexao;
        
        //a linha abaixo "chama" o driver
        String driver = "com.mysql.cj.jdbc.Driver";
        
        //Armazenando informações referente ao banco
        String url = "jdbc:mysql://localhost:3306/tads241";//?useTimeZone=true&serverTimezone=UTC"; 
        String user = "root";
        String password = "";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            
            //System.out.println(conexao);
            return conexao;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
