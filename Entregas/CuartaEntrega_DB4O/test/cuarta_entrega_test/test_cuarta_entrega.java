/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuarta_entrega_test;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import cuartaentrega_ad.Biblioteca;
import cuartaentrega_ad.Ciudad;
import cuartaentrega_ad.Libro;
import cuartaentrega_ad.Persona;
import java.util.ArrayList;
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
public class test_cuarta_entrega {
    
    public test_cuarta_entrega() {
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
    
    public void test_insertar_y_leer_en_base_de_datos_ciudad(){
        //Insertar
        int id = 0;
        String nombre = "Granada";
        String pais = "España";
        int num_hab = 900000;
        ArrayList<Ciudad> ciudades=new ArrayList();
        ObjectContainer db = Db4o.openFile("test_ciudades.db4o");
        Ciudad c = new Ciudad (id, nombre, pais, num_hab);       
        db.store(c); 

        //Leer
        Query q = db.query();
        q.constrain(Ciudad.class);
        ObjectSet result = q.execute();       
        System.out.println(result.size());
        while(result.hasNext()) {
            Ciudad city = new Ciudad();
            city = (Ciudad) result.next();
            ciudades.add(city);
        }
        db.close();
        
        Assert.assertEquals(ciudades.size(),1);
        Assert.assertEquals(ciudades.get(0).getId_ciudad(), id);
        Assert.assertEquals(ciudades.get(0).getNombre(), nombre);
        Assert.assertEquals(ciudades.get(0).getPais(), pais);
        Assert.assertEquals(ciudades.get(0).getNum_habitantes(),num_hab);
    }
    
    public void test_insertar_y_leer_en_base_de_datos_biblioteca(){
        //Insertar
        int id = 0;
        String nombre = "Biblioteca Pública Andalucía";
        String telefono = "958654654";
        String direccion ="Calle1";
        int id_ciu = 0;
        ArrayList<Biblioteca> bibliotecas = new ArrayList();
        
        ObjectContainer db = Db4o.openFile("test_bibliotecas.db4o");
        Biblioteca b = new Biblioteca (id, nombre, telefono, direccion, id_ciu);
        db.store(b); 

        //Leer
        Query q = db.query();
        q.constrain(Biblioteca.class);
        ObjectSet result = q.execute();       
        System.out.println(result.size());
        while(result.hasNext()) {
            Biblioteca bib = new Biblioteca();
            bib = (Biblioteca) result.next();
            bibliotecas.add(bib);
        }
        db.close();
        
        Assert.assertEquals(bibliotecas.size(),1);
        Assert.assertEquals(bibliotecas.get(0).getId_biblioteca(), id);
        Assert.assertEquals(bibliotecas.get(0).getNombre(), nombre);
        Assert.assertEquals(bibliotecas.get(0).getTelefono(), telefono);
        Assert.assertEquals(bibliotecas.get(0).getDireccion(),direccion);
    }
    
    public void test_insertar_y_leer_en_base_de_datos_libro(){
        //Insertar
        int id = 0;
        String titulo = "Hush Hush";
        String autor = "Becca Fitzpatrick";
        int anio_pub =2009;
        int edad_rec = 12;
        int id_bib = 0;
        ArrayList<Libro> libros = new ArrayList();
        
        ObjectContainer db = Db4o.openFile("test_libros.db4o");
        Libro l = new Libro (id, titulo, autor, anio_pub, edad_rec, id_bib);
        db.store(l); 

        //Leer
        Query q = db.query();
        q.constrain(Libro.class);
        ObjectSet result = q.execute();       
        System.out.println(result.size());
        while(result.hasNext()) {
            Libro lib = new Libro();
            lib = (Libro) result.next();
            libros.add(lib);
        }
        db.close();
        
        Assert.assertEquals(libros.size(),1);
        Assert.assertEquals(libros.get(0).getId_libro(), id);
        Assert.assertEquals(libros.get(0).getTitulo(), titulo);
        Assert.assertEquals(libros.get(0).getAutor(), autor);
        Assert.assertEquals(libros.get(0).getAnio_publicacion(),anio_pub);
        Assert.assertEquals(libros.get(0).getEdad_recomendada(),edad_rec);
    }
    
    public void test_insertar_y_leer_en_base_de_datos_persona(){
        //Insertar
        int id = 0;
        String DNI = "12345678A";
        String nombre = "Becca Fitzpatrick";
        String edad = "36";
        String ciudad_nat = "Nueva York";
        int id_lib = 0;
        ArrayList<Persona> personas = new ArrayList();
        
        ObjectContainer db = Db4o.openFile("test_personas.db4o");
        Persona p = new Persona (id, DNI,nombre, edad, ciudad_nat, id_lib);
        db.store(p); 

        //Leer
        Query q = db.query();
        q.constrain(Persona.class);
        ObjectSet result = q.execute();       
        System.out.println(result.size());
        while(result.hasNext()) {
            Persona per = new Persona();
            per = (Persona) result.next();
            personas.add(per);
        }
        db.close();
        
        Assert.assertEquals(personas.size(),1);
        Assert.assertEquals(personas.get(0).getId_persona(), id);
        Assert.assertEquals(personas.get(0).getNombre(), nombre);
        Assert.assertEquals(personas.get(0).getEdad(), edad);
        Assert.assertEquals(personas.get(0).getCiudad_natal(),ciudad_nat);
    }
}
