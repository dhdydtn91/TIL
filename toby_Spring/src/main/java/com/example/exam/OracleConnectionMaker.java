package com.example.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionMaker implements SimpleConnectionMaker {
    @Override
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver\"");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/springbook?serverTimezone=Asia/Seoul", "cos", "cos1234");
    }
}
