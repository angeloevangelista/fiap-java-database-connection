package br.com.fiap;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionFactory.getConnection();

            System.out.println("Conexão estabilisada");
        } catch (SQLException e) {
            System.out.printf("Database error: %s\n", e.getMessage());
        }
    }
}