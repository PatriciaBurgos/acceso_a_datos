/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ORM.Biblioteca;
import ORM.Ciudad;
import ORM.Libro;
import ORM.NewHibernateUtil;
import ORM.Persona;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author patri
 */
public class test_quinta_entrega {
    
    public test_quinta_entrega() {
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
        Persona persona = new Persona("11111111A", "Katniss Everdeen", "20", "Distrito13", 0);
        Assert.assertEquals("Katniss Everdeen", persona.getNombre());
        Assert.assertEquals("11111111A", persona.getDni());
        Assert.assertEquals("20", persona.getEdad());
    }
    
    public void test_insertar_persona_array(){
        Persona persona = new Persona("11111111A", "Katniss Everdeen", "20", "Distrito13", 0);
        ArrayList <Persona> personas = new ArrayList();
        personas.add(persona);
        
        Assert.assertEquals(personas.size(), 1);
        Assert.assertEquals(personas.get(0).getIdPersona(),persona.getIdPersona());
        Assert.assertEquals(personas.get(0).getNombre(),persona.getNombre());
    }
    
    public void test_eliminar_persona_array(){
        Persona persona = new Persona("11111111A", "Katniss Everdeen", "20", "Distrito13", 0);
        ArrayList <Persona> personas = new ArrayList();
        personas.add(persona);
        personas.remove(0);
        
        Assert.assertEquals(personas.size(), 0);
    }
    
    public void test_insertar_libro_array(){
        Libro libro = new Libro ("El Quijote", "Miguel de Cervantes",1605,12 , 0);
        ArrayList <Libro> libros = new ArrayList();
        libros.add(libro);
        
        Assert.assertEquals(libros.size(),1);
        Assert.assertEquals(libros.get(0).getIdLibro(),libro.getIdLibro());
        Assert.assertEquals(libros.get(0).getTitulo(),libro.getTitulo());
        Assert.assertEquals(libros.get(0).getAutor(),libro.getAutor());
    }
    
    public void test_insertar_biblioteca_array(){
        Biblioteca biblioteca = new Biblioteca ("Biblioteca Pública Municipal Albayzin", "958123123", "Plaza Cementerio de San Nicolás", 0);        
        ArrayList <Biblioteca> bibliotecas = new ArrayList();
        bibliotecas.add(biblioteca);
        
        Assert.assertEquals(bibliotecas.size(),1);        
        Assert.assertEquals(bibliotecas.get(0).getIdBiblioteca(),biblioteca.getIdBiblioteca());
        Assert.assertEquals(bibliotecas.get(0).getNombre(),biblioteca.getNombre());
    }
    
    public void test_insertar_y_leer_en_base_de_datos_ciudad(){
        //Insertar
        Transaction t = null;         
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        ORM.Ciudad ciu = new ORM.Ciudad();
        ciu.setNombre("Cádiz");
        ciu.setPais("España");
        ciu.setNumHabitantes(100000);
        s.save(ciu);
        t.commit(); 
        s.refresh(ciu);
        s.close();
        
        //Leer
        Query q = (Query) s.createQuery("FROM Ciudad").setReadOnly(true);
        List<ORM.Ciudad> listciu = s.createQuery("FROM Ciudad").list();
        
        ArrayList <Ciudad> ciudades = new ArrayList();
        for (ORM.Ciudad unciu : listciu) {
            ciudades.add(unciu);
        }
        s.close();
        
        Assert.assertEquals(ciudades.size(),1);
        Assert.assertEquals(ciudades.get(0).getNombre(), ciu.getNombre());
        Assert.assertEquals(ciudades.get(0).getPais(), ciu.getPais());
        Assert.assertEquals(ciudades.get(0).getNumHabitantes(),ciu.getNumHabitantes());
    }
    
    public void test_insertar_y_leer_en_base_de_datos_biblioteca(){
        //Insertar
        String nombre = "Biblioteca Pública Andalucía";
        String telefono = "958654654";
        String direccion ="Calle1";
        int id_ciu = 0;
        Transaction t = null;         
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        ORM.Biblioteca bib = new ORM.Biblioteca();
        bib.setNombre(nombre);
        bib.setTelefono(telefono);
        bib.setDireccion(direccion);
        bib.setIdCiudad(id_ciu);
        s.save(bib);
        t.commit(); 
        s.refresh(bib);
        s.close();

        //Leer        
        Query q = (Query) s.createQuery("FROM Biblioteca").setReadOnly(true);
        List<ORM.Biblioteca> listbib = s.createQuery("FROM Biblioteca").list();
        ArrayList <Biblioteca> bibliotecas = new ArrayList();
        for (ORM.Biblioteca unbib : listbib) {
            bibliotecas.add(unbib);
        }
        s.close();
        
        Assert.assertEquals(bibliotecas.size(),1);
        Assert.assertEquals(bibliotecas.get(0).getNombre(), nombre);
        Assert.assertEquals(bibliotecas.get(0).getTelefono(), telefono);
        Assert.assertEquals(bibliotecas.get(0).getDireccion(),direccion);
    }
    
    public void test_insertar_y_leer_en_base_de_datos_libro(){
        //Insertar
        int id = 0;
        String titulo = "Hush Hush";
        String autor = "Becca Fitzpatrick";
        Integer anio_pub =2009;
        Integer edad_rec = 12;
        int id_bib = 0;
        ArrayList<Libro> libros = new ArrayList();
        
        Transaction t = null;         
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        ORM.Libro lib = new ORM.Libro();
        lib.setTitulo(titulo);
        lib.setAutor(autor);
        lib.setAnioPublicacion(anio_pub);
        lib.setEdadRecomendada(edad_rec);
        lib.setIdBiblioteca(id_bib);
        s.save(lib);
        t.commit(); 
        s.refresh(lib);
        s.close(); 

        //Leer
        Query q = (Query) s.createQuery("FROM Libro").setReadOnly(true);
        List<ORM.Libro> listlib = s.createQuery("FROM Libro").list();
        for (ORM.Libro unlib : listlib) {
            libros.add(unlib);
        }
        s.close();
        
        Assert.assertEquals(libros.size(),1);
        Assert.assertEquals(libros.get(0).getTitulo(), titulo);
        Assert.assertEquals(libros.get(0).getAutor(), autor);
        Assert.assertEquals(libros.get(0).getAnioPublicacion(),anio_pub);
        Assert.assertEquals(libros.get(0).getEdadRecomendada(),edad_rec);
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
        
        Transaction t = null;         
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction(); 
        ORM.Persona per = new ORM.Persona();
        per.setDni(DNI);
        per.setNombre(nombre);
        per.setEdad(edad);
        per.setCiudadNatal(ciudad_nat);
        per.setIdLibro(id_lib);
        s.save(per);
        t.commit(); 
        s.refresh(per);
        s.close();

        //Leer
        Query q = (Query) s.createQuery("FROM Persona").setReadOnly(true);
        List<ORM.Persona> listper = s.createQuery("FROM Persona").list();
        for (ORM.Persona unper : listper) {
            personas.add(unper);
        }
        s.close();
        
        Assert.assertEquals(personas.size(),1);
        Assert.assertEquals(personas.get(0).getNombre(), nombre);
        Assert.assertEquals(personas.get(0).getEdad(), edad);
        Assert.assertEquals(personas.get(0).getCiudadNatal(),ciudad_nat);
    }
    
    public void test_eliminar_y_leer_en_base_de_datos_persona(){
        int id = 0;
        ArrayList<Persona> personas = new ArrayList();
        
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        ORM.Persona per = (ORM.Persona) s.get(ORM.Persona.class, id);
        if (per != null) {
            s.delete(per);
        }
        s.close();
        
        Query q = (Query) s.createQuery("FROM Persona").setReadOnly(true);
        List<ORM.Persona> listper = s.createQuery("FROM Persona").list();
        for (ORM.Persona unper : listper) {
            personas.add(unper);
        }
        s.close();
        
        Assert.assertEquals(personas.size(), 0);
        Assert.assertEquals(personas.get(0).getIdPersona(),null);
        Assert.assertEquals(personas.get(0).getDni(),null);
        Assert.assertEquals(personas.get(0).getNombre(),null);
        Assert.assertEquals(personas.get(0).getEdad(),null);
    }
}
