/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyecto2Progra2.Cell;

/**
 *
 * @author fabian
 */
public class LogicTest {
    
    public LogicTest() {
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

    /**
     * Test of createGridPane method, of class Logic.
     */
    @Test
    public void testCreateGridPane() {
        System.out.println("createGridPane");
        int rows = 0;
        int columns = 0;
        Cell[][] cell = null;
        Logic instance = new Logic();
        GridPane expResult = null;
        GridPane result = instance.createGridPane(rows, columns, cell);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGridPaneToAnchorPane method, of class Logic.
     */
    @Test
    public void testAddGridPaneToAnchorPane() {
        System.out.println("addGridPaneToAnchorPane");
        AnchorPane anchorPane = null;
        GridPane gridPane = null;
        Logic instance = new Logic();
        AnchorPane expResult = null;
        AnchorPane result = instance.addGridPaneToAnchorPane(anchorPane, gridPane);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNumeric method, of class Logic.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        KeyEvent event = null;
        Logic instance = new Logic();
        boolean expResult = false;
        boolean result = instance.isNumeric(event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
