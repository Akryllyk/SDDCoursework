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

public class DataQualityCheck {

    private DatabaseHandler handler = new DatabaseHandler();
    Connection con = handler.handleDbConnection();
}
