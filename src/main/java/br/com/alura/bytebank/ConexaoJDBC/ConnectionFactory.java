package br.com.alura.bytebank.ConexaoJDBC;

import java.sql.*;
import java.util.Scanner;

public class ConnectionFactory {
    public Connection recuperarConexao() {
        Scanner sc = new Scanner(System.in);
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/byte_bank",
                    "postgres",
                    sc.next());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}