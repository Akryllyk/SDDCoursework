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
    
    //create a Database Handler object.
    private DatabaseHandler handler = new DatabaseHandler();
    
    //search for no crime IDs
    public void noCrimeIDCheck() {

        try {
            FileWriter noIDFileWriter = new FileWriter("nocrimeid.txt");
            BufferedWriter noIDBufferedWriter = new BufferedWriter(noIDFileWriter);
            String query = "SELECT * FROM `crimedata` WHERE `Crime ID` = ''";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                //write to file
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    
    //search for duplicate crime IDs
    public void dupeCrimeIDCheck() {
        try {
            String query = "SELECT *, COUNT(`Crime ID`) FROM `crimedata` WHERE `Crime ID` != '' GROUP BY `Crime ID` HAVING COUNT(`Crime ID`) > 1";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
