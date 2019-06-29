/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author son
 */
public class DBCore implements Serializable {

    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=javaweb_workshop1";
        connection = DriverManager.getConnection(url, "son", "son");
        return connection;
    }
}
