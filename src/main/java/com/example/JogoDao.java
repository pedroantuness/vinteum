package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;


public class JogoDao {
    
    private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private final String USER = "";
    private final String PASS = "";

    public void inserir(Jogo jogo) throws SQLException {
        var con = DriverManager.getConnection(URL, USER, PASS);
        var sql = "INSERT INTO jogo (resultados) VALUES (?)";
        var instrucao = con.prepareStatement(sql);
        instrucao.setString(1, jogo.resultado());
        instrucao.executeUpdate();
        con.close();
    }
}