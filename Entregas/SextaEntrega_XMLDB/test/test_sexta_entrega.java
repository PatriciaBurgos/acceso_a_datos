/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sextaentrega_xmldb.Ciudad;
import sextaentrega_xmldb.Ventana1;
import static sextaentrega_xmldb.Ventana1.ciudades;

/**
 *
 * @author patri
 */
public class test_sexta_entrega {
    
    public test_sexta_entrega() {
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
    public void test_insertar_y_leer_una_ciudad () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, XQException, XQException{
        
        Ventana1.ciudades = new ArrayList();
        Ventana1.insertar_una_ciudad(100, "Murcia", "España", 10);
        Ventana1.leer_ciudades();
        

        Assert.assertEquals(Ventana1.ciudades.get(Ventana1.ciudades.size()-1).getNombre(), "Murcia");
        Assert.assertEquals(Ventana1.ciudades.get(Ventana1.ciudades.size()-1).getPais(), "España");
        
    }
    
    
    public void test_consultar_ultimo_id_ciudad() throws SQLException{
        Ventana1.ciudades = new ArrayList();
           
        Ventana1.leer_ciudades();
        int tamanio = Ventana1.ciudades.size();
        Ventana1.eliminar_una_ciudad(100);
        int tamanio2 = Ventana1.ciudades.size();
        
        Assert.assertEquals(tamanio, tamanio2);
    }
    
    
}
