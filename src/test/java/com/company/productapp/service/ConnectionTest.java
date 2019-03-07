package com.company.productapp.service;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    public void testConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/training", "digyamp", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
