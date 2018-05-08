/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

/**
 *
 * @author arvmayes
 */
import java.io.*;
import java.sql.*;

public class DataQualityCheck {

    private DatabaseHandler handler = new DatabaseHandler();

    public void noCrimeIDCheck() {
        try {
            String query = "SELECT * FROM 'crimedata' WHERE 'Crime ID' = ''";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            FileWriter writeNoID = ;
            while(rs.next()){
                
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    public void dupeCrimeIDCheck() {
        try {
            String query = "SELECT *, COUNT('Crime ID') FROM 'crimedata' WHERE 'Crime ID' != \"\" GROUP BY 'Crime ID' HAVING COUNT('Crime ID') > 1";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
