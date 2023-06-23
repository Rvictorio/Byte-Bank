package br.com.alura.bytebank.ConexaoJDBC;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.Scanner;

public class ConnectionFactory {
    Scanner sc = new Scanner(System.in);
    public Connection recuperarConexao() {

        System.out.println("Coloque a senha do banco de dados!");
        try {
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        }
    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/byte_bank");
        config.setUsername("postgres");
        config.setPassword(sc.next());
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}