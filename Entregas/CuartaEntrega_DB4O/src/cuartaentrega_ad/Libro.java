/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuartaentrega_ad;

/**
 *
 * @author Patricia Burgos
 */
public class Libro {
    private int id_libro;
    private String titulo;
    private String autor;
    private int anio_publicacion;
    private int edad_recomendada;
    private int id_biblioteca;

    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.anio_publicacion = 0;
        this.edad_recomendada = 0;
        this.id_biblioteca = 0;
    }
    
    public Libro(int id_libro, String titulo, String autor, int anio_publicacion, int edad_recomendada, int id_biblioteca) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.autor = autor;
        this.anio_publicacion = anio_publicacion;
        this.edad_recomendada = edad_recomendada;
        this.id_biblioteca = id_biblioteca;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public int getEdad_recomendada() {
        return edad_recomendada;
    }

    public void setEdad_recomendada(int edad_recomendada) {
        this.edad_recomendada = edad_recomendada;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }
}
