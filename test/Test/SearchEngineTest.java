package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import SearchEngine.*;
import java.sql.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arvmayes
 */
public class SearchEngineTest extends junit.framework.TestCase {

    public SearchEngineTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testHandler() {
        DatabaseHandler handler = new DatabaseHandler();
        Connection test = handler.handleDbConnection();
        try {
            assertEquals(test.getCatalog(), "arvmayes");
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

    }
    
    @Test
    public void testGUI(){
        GUIHandler gui = new GUIHandler();
        GUIHandler gui2 = gui.getMe();
        try{
            assertEquals(gui2.getName(), gui.getName());
        } catch (Exception e){
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
