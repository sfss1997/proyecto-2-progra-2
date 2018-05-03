/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import Domain.Images;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
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
public class ImagesAdministrationTest {
    
    public ImagesAdministrationTest() {
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
     * Test of generarDocumento method, of class ImagesAdministration.
     */
    @Test
    public void testGenerarDocumento() throws ParserConfigurationException {
        System.out.println("generarDocumento");
        ImagesAdministration instance = new ImagesAdministration();
        instance.generarDocumento();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateXml method, of class ImagesAdministration.
     */
    @Test
    public void testGenerateXml() throws Exception {
        System.out.println("generateXml");
        ImagesAdministration instance = new ImagesAdministration();
        instance.generateXml();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readXml method, of class ImagesAdministration.
     */
    @Test
    public void testReadXml() throws Exception {
        System.out.println("readXml");
        ImagesAdministration instance = new ImagesAdministration();
        ArrayList<Images> expResult = null;
        ArrayList<Images> result = instance.readXml();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
