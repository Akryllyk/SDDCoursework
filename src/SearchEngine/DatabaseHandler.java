package SearchEngine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author arvmayes
 */
import java.sql.*;

public class DatabaseHandler {

    public Connection handleDbConnection() {
        Connection con = null;
        try {
            String username = "";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://lamp.scim.brad.ac.uk:3306/arvmayes", username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
