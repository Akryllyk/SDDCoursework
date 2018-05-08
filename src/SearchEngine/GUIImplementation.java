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
import java.sql.*;
import javax.swing.*;

public class GUIImplementation {

    private DatabaseHandler handler = new DatabaseHandler();
    String[] columnNames = {"Crime ID", "Month", "Reported by", "Falls Within", "Longitude", "Latitude", "Location", "LSOA code", "LSOA name", "Crime type", "Last outcome category", "Context"};

    public JTable longLatSearch() {
        JTable resultsTable = null;
        try {
            String query = "SELECT * FROM 'crimedata' WHERE 'Longitude' LIKE 'input%' OR 'Latitude' LIKE 'input%' LIMIT 10";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return resultsTable;
    }

    public JTable lsoaSearch() {
        JTable resultsTable = null;
        try {
            String query = "SELECT * FROM 'crimedata' WHERE 'LSOA Name' LIKE '%input%' LIMIT 10";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return resultsTable;
    }

    public JTable crimeTypeSearch() {
        JTable resultsTable = null;
        try {
            String query = "SELECT * FROM 'crimedata' WHERE 'Crime type' = input LIMIT 10";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return resultsTable;
    }

}
