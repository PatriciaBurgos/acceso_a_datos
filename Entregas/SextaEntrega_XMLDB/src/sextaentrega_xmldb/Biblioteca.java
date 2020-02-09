package sextaentrega_xmldb;

public class Biblioteca  implements java.io.Serializable {


     private Integer idBiblioteca;
     private String nombre;
     private String telefono;
     private String direccion;
     private Integer idCiudad;

    public Biblioteca() {
    }

    public Biblioteca(String nombre, String telefono, String direccion, Integer idCiudad) {
       this.nombre = nombre;
       this.telefono = telefono;
       this.direccion = direccion;
       this.idCiudad = idCiudad;
    }
   
    public Integer getIdBiblioteca() {
        return this.idBiblioteca;
    }
    
    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Integer getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }




}

