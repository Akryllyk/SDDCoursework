
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arvmayes
 */
public class DatabaseHandler {
    
 public void handleDbConnection(){
        String username = "arvmayes";
            String password = "testtest";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con= DriverManager.getConnection("jdbc:mysql://lamp.scim.brad.ac.uk:3306/arvmayes", username, password);
 }
}
