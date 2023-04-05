package ru.mamedova.connetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationConnection {
    private Connection getConnection () throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        String password = "password";

        final Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public PreparedStatement getPrepareStatement (String sql) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement(sql);
        return statement;
    }
}