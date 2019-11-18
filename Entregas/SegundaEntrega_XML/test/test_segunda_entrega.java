/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import segundaentrega_ad.Biblioteca;
import segundaentrega_ad.Libro;
import segundaentrega_ad.Persona;

/**
 *
 * @author Patricia Burgos
 */
public class test_segunda_entrega {
    
    public test_segunda_entrega() {
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

    // TODO add test methods here.
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
    
    public void test_insertar_persona_array(){
        Persona persona = new Persona(1, "11111111A", "Katniss Everdeen", "20", "Distrito13", 0);
        ArrayList <Persona> personas = new ArrayList();
        personas.add(persona);
        
        Assert.assertEquals(personas.size(), 1);
        Assert.assertEquals(personas.get(0).getId_persona(),persona.getId_persona());
        Assert.assertEquals(personas.get(0).getNombre(),persona.getNombre());
    }
    
    public void test_eliminar_persona_array(){
        Persona persona = new Persona(1, "11111111A", "Katniss Everdeen", "20", "Distrito13", 0);
        ArrayList <Persona> personas = new ArrayList();
        personas.add(persona);
        personas.remove(0);
        
        Assert.assertEquals(personas.size(), 0);
    }
    
    public void test_insertar_libro_array(){
        Libro libro = new Libro (1,"El Quijote", "Miguel de Cervantes",1605,12 , 0);
        ArrayList <Libro> libros = new ArrayList();
        libros.add(libro);
        
        Assert.assertEquals(libros.size(),1);
        Assert.assertEquals(libros.get(0).getId_libro(),libro.getId_libro());
        Assert.assertEquals(libros.get(0).getTitulo(),libro.getTitulo());
        Assert.assertEquals(libros.get(0).getAutor(),libro.getAutor());
    }
    
    public void test_insertar_biblioteca_array(){
        Biblioteca biblioteca = new Biblioteca (0,"Biblioteca Pública Municipal Albayzin", "958123123", "Plaza Cementerio de San Nicolás", 0);        
        ArrayList <Biblioteca> bibliotecas = new ArrayList();
        bibliotecas.add(biblioteca);
        
        Assert.assertEquals(bibliotecas.size(),1);        
        Assert.assertEquals(bibliotecas.get(0).getId_biblioteca(),biblioteca.getId_biblioteca());
        Assert.assertEquals(bibliotecas.get(0).getNombre(),biblioteca.getNombre());
    }
}
