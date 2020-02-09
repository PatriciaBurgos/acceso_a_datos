package sextaentrega_xmldb;


public class Libro  implements java.io.Serializable {


     private Integer idLibro;
     private String titulo;
     private String autor;
     private Integer anioPublicacion;
     private Integer edadRecomendada;
     private Integer idBiblioteca;

    public Libro() {
    }

    public Libro(String titulo, String autor, Integer anioPublicacion, Integer edadRecomendada, Integer idBiblioteca) {
       this.titulo = titulo;
       this.autor = autor;
       this.anioPublicacion = anioPublicacion;
       this.edadRecomendada = edadRecomendada;
       this.idBiblioteca = idBiblioteca;
    }
   
    public Integer getIdLibro() {
        return this.idLibro;
    }
    
    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Integer getAnioPublicacion() {
        return this.anioPublicacion;
    }
    
    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    public Integer getEdadRecomendada() {
        return this.edadRecomendada;
    }
    
    public void setEdadRecomendada(Integer edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }
    public Integer getIdBiblioteca() {
        return this.idBiblioteca;
    }
    
    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }




}

