package com.example.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface SimpleConnectionMaker {

    //mysql
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException;

    //orcle

    //maria

    //mongodb


}
