/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.util.ArrayList;
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
public class ProyectsAdministrationTest {
    
    public ProyectsAdministrationTest() {
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
     * Test of writeJson method, of class ProyectsAdministration.
     */
    @Test
    public void testWriteJson() {
        System.out.println("writeJson");
        String name = "";
        ArrayList url = null;
        ArrayList x = null;
        ArrayList y = null;
        int columns = 0;
        int rows = 0;
        ProyectsAdministration instance = new ProyectsAdministration();
        instance.writeJson(name, url, x, y, columns, rows);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readJson method, of class ProyectsAdministration.
     */
    @Test
    public void testReadJson() throws Exception {
        System.out.println("readJson");
        ProyectsAdministration instance = new ProyectsAdministration();
        ArrayList expResult = null;
        ArrayList result = instance.readJson();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
