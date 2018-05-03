/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fabian
 */
public class CellTest {
    
    public CellTest() {
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
     * Test of getRow method, of class Cell.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Cell instance = new Cell();
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRow method, of class Cell.
     */
    @Test
    public void testSetRow() {
        System.out.println("setRow");
        int row = 0;
        Cell instance = new Cell();
        instance.setRow(row);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumn method, of class Cell.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Cell instance = new Cell();
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColumn method, of class Cell.
     */
    @Test
    public void testSetColumn() {
        System.out.println("setColumn");
        int column = 0;
        Cell instance = new Cell();
        instance.setColumn(column);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrl method, of class Cell.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        Cell instance = new Cell();
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class Cell.
     */
    @Test
    public void testSetUrl() {
        System.out.println("setUrl");
        String url = "";
        Cell instance = new Cell();
        instance.setUrl(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
