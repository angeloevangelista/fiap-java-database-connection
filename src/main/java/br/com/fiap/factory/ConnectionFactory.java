package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@oracle.domain.com.br:1521:ORCL",
                user,
                password
        );

        return connection;
    }
}
