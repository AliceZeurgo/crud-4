package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String servidor, senha, usuario, banco;
    public Connection conexao;
    public Conexao(){
        this.servidor = "LocalHost";
        this.banco = "loja_virtual";
        this.usuario = "root";
        this.senha = "bcd127";
    }

    public void  connectionDiver() throws SQLException {

        this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco, this.usuario, this.senha);
    }

    public Connection getConnection() throws SQLException {
        connectionDiver();
        return conexao;
    }

}