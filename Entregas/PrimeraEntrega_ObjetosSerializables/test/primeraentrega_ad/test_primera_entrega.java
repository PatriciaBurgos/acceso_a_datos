/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeraentrega_ad;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Patricia Burgos
 */
public class test_primera_entrega {
    
    public test_primera_entrega() {
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

    // TODO add test_primera_entrega methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void test_constructor_clase_persona() {
        Persona persona = new Persona(1, "11111111A", "Katniss Everdeen", "20", "Distrito13", 0);
        Assert.assertEquals("Katniss Everdeen", persona.getNombre());
        Assert.assertEquals(1, persona.getId_persona());
        Assert.assertEquals("20", persona.getEdad());
    }
    
    @Test
    public void test_vaciar_campos_detallados_biblioteca() throws IOException, FileNotFoundException, ClassNotFoundException {
        Ventana1 vent = new Ventana1();
        vent.jTextField_nombre_biblioteca.setText("");
        vent.jTextField_telefono.setText("");
        vent.jTextField_direccion.setText("");
        vent.jComboBox_biblioteca.removeAll();
        Assert.assertEquals("", vent.jTextField_nombre_biblioteca.getText());
        Assert.assertEquals("", vent.jTextField_telefono.getText());
        Assert.assertEquals("", vent.jTextField_direccion.getText());        
    }
    
    @Test
    public void test_desactivar_botones_gc_libro() throws IOException, FileNotFoundException, ClassNotFoundException {
        Ventana1 vent = new Ventana1(); 
        vent.jButton_guardar_libro.setEnabled(false);
        vent.jButton_cancelar_libro.setEnabled(false);
        vent.jComboBox_libro.setEnabled(false);
        Assert.assertEquals(false, vent.jButton_guardar_libro.isEnabled());
        Assert.assertEquals(false, vent.jButton_cancelar_libro.isEnabled());
        Assert.assertEquals(false, vent.jComboBox_libro.isEnabled());
    }
    
    @Test
    public void test_editable_si_ciudad() throws IOException, FileNotFoundException, ClassNotFoundException {
        Ventana1 vent = new Ventana1(); 
        vent.jTextField_nombre_ciudad.setEditable(true);
        vent.jTextField_pais.setEditable(true);
        vent.jTextField_num_habitantes.setEditable(true);
        Assert.assertEquals(true, vent.jTextField_nombre_ciudad.isEditable());
        Assert.assertEquals(true, vent.jTextField_pais.isEditable());
        Assert.assertEquals(true, vent.jTextField_num_habitantes.isEditable());
    }
    
    @Test
    public void test_activar_botones_amb_persona() throws IOException, FileNotFoundException, ClassNotFoundException {
        Ventana1 vent = new Ventana1(); 
        vent.jButton_aniadir_persona.setEnabled(true);
        vent.jButton_modificar_persona.setEnabled(true);
        vent.jButton_borrar_persona.setEnabled(true);
        vent.jTable_persona.setEnabled(true);        
        Assert.assertEquals(true, vent.jButton_aniadir_persona.isEnabled());
        Assert.assertEquals(true, vent.jButton_modificar_persona.isEnabled());
        Assert.assertEquals(true, vent.jButton_borrar_persona.isEnabled());
        Assert.assertEquals(true, vent.jTable_persona.isEnabled());
    }
    
    
}
