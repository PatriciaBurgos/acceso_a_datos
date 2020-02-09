package sextaentrega_xmldb;

public class Persona  implements java.io.Serializable {


     private Integer idPersona;
     private String dni;
     private String nombre;
     private String edad;
     private String ciudadNatal;
     private Integer idLibro;

    public Persona() {
    }

    public Persona(String dni, String nombre, String edad, String ciudadNatal, Integer idLibro) {
       this.dni = dni;
       this.nombre = nombre;
       this.edad = edad;
       this.ciudadNatal = ciudadNatal;
       this.idLibro = idLibro;
    }
   
    public Integer getIdPersona() {
        return this.idPersona;
    }
    
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEdad() {
        return this.edad;
    }
    
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getCiudadNatal() {
        return this.ciudadNatal;
    }
    
    public void setCiudadNatal(String ciudadNatal) {
        this.ciudadNatal = ciudadNatal;
    }
    public Integer getIdLibro() {
        return this.idLibro;
    }
    
    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }




}


