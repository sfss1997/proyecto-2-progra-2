/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2Progra2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class SpriteControllerTest {
    
    public SpriteControllerTest() {
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
     * Test of initialize method, of class SpriteController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        SpriteController instance = new SpriteController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGridPane method, of class SpriteController.
     */
    @Test
    public void testCreateGridPane() throws Exception {
        System.out.println("createGridPane");
        ActionEvent event = null;
        SpriteController instance = new SpriteController();
        instance.createGridPane(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportAsImage method, of class SpriteController.
     */
    @Test
    public void testExportAsImage() {
        System.out.println("exportAsImage");
        SpriteController instance = new SpriteController();
        instance.exportAsImage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelectedItem method, of class SpriteController.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        SpriteController instance = new SpriteController();
        instance.setSelectedItem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedItem method, of class SpriteController.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        SpriteController instance = new SpriteController();
        String expResult = "";
        String result = instance.getSelectedItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
