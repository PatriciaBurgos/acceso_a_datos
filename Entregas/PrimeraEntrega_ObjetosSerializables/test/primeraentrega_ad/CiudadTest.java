/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeraentrega_ad;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Patricia Burgos
 */
public class CiudadTest {
    
    public CiudadTest() {
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
     * Test of getId_ciudad method, of class Ciudad.
     */
    @Test
    public void testGetId_ciudad() {
        System.out.println("getId_ciudad");
        Ciudad instance = new Ciudad();
        int expResult = 0;
        int result = instance.getId_ciudad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_ciudad method, of class Ciudad.
     */
    @Test
    public void testSetId_ciudad() {
        System.out.println("setId_ciudad");
        int id_ciudad = 0;
        Ciudad instance = new Ciudad();
        instance.setId_ciudad(id_ciudad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Ciudad.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Ciudad instance = new Ciudad();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Ciudad.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Ciudad instance = new Ciudad();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPais method, of class Ciudad.
     */
    @Test
    public void testGetPais() {
        System.out.println("getPais");
        Ciudad instance = new Ciudad();
        String expResult = "";
        String result = instance.getPais();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPais method, of class Ciudad.
     */
    @Test
    public void testSetPais() {
        System.out.println("setPais");
        String pais = "";
        Ciudad instance = new Ciudad();
        instance.setPais(pais);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNum_habitantes method, of class Ciudad.
     */
    @Test
    public void testGetNum_habitantes() {
        System.out.println("getNum_habitantes");
        Ciudad instance = new Ciudad();
        int expResult = 0;
        int result = instance.getNum_habitantes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNum_habitantes method, of class Ciudad.
     */
    @Test
    public void testSetNum_habitantes() {
        System.out.println("setNum_habitantes");
        int num_habitantes = 0;
        Ciudad instance = new Ciudad();
        instance.setNum_habitantes(num_habitantes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
