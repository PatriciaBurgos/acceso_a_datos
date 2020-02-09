package sextaentrega_xmldb;

public class Ciudad  implements java.io.Serializable {


     private Integer idCiudad;
     private String nombre;
     private String pais;
     private Integer numHabitantes;

    public Ciudad() {
    }

    public Ciudad(String nombre, String pais, Integer numHabitantes) {
       this.nombre = nombre;
       this.pais = pais;
       this.numHabitantes = numHabitantes;
    }
   
    public Integer getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public Integer getNumHabitantes() {
        return this.numHabitantes;
    }
    
    public void setNumHabitantes(Integer numHabitantes) {
        this.numHabitantes = numHabitantes;
    }




}


