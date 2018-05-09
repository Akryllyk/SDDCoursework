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
import javax.swing.table.DefaultTableModel;

public class GUIImplementation {

    private DatabaseHandler handler = new DatabaseHandler();
    String[] columnNames = {"Crime ID", "Month", "Reported by", "Falls Within", "Longitude", "Latitude", "Location", "LSOA code", "LSOA name", "Crime type", "Last outcome category", "Context"};

    //longitute / latitude search ascending
    public JTable longLatSearch(String longSearch, String latSearch, String sort) {
        DefaultTableModel model = new DefaultTableModel();
        JTable resultsTable = new JTable(model);

        try {
            String query = "SELECT * FROM `crimedata` WHERE `Longitude` LIKE '" + longSearch + "%' OR `Latitude` LIKE '" + latSearch + "%' ORDER BY `Longitude` " + sort + " LIMIT 10";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();

            model.setColumnIdentifiers(columnNames);
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getObject(i + 1);

                }
                model.addRow(row);

            }
            resultsTable.setModel(model);
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return resultsTable;
    }

    //LSOA Name Search
    public JTable lsoaSearch(String lsoaName, String sort) {
        DefaultTableModel model = new DefaultTableModel();
        JTable resultsTable = new JTable(model);

        try {
            String query = "SELECT * FROM `crimedata` WHERE `LSOA Name` LIKE '%" + lsoaName + "%' ORDER BY `Crime ID` " + sort + " LIMIT 10";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();

            model.setColumnIdentifiers(columnNames);
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getObject(i + 1);

                }
                model.addRow(row);

            }
            resultsTable.setModel(model);
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return resultsTable;
    }

    //search for crime type
    public JTable crimeTypeSearch(String crimeType, String sort) {
        DefaultTableModel model = new DefaultTableModel();
        JTable resultsTable = new JTable(model);

        try {
            String query = "SELECT * FROM `crimedata` WHERE `Crime type` = '" + crimeType + "' ORDER BY `Month` DESC LIMIT 10";
            Connection con = handler.handleDbConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();

            model.setColumnIdentifiers(columnNames);
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getObject(i + 1);

                }
                model.addRow(row);

            }
            resultsTable.setModel(model);
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return resultsTable;
    }

}
