/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escribir_xml;


/**
 *
 * @author Patricia Burgos
 */
public class Animal{
    private int id;
    private String nombre;
    private int anios;
    private String provincia;
    private String apellido_familia;

    public Animal() {
        this.id=0;
        this.nombre = "";
        this.anios = 0;
        this.provincia = "";
        this.apellido_familia = "";
    }
    
    public Animal(int id, String nombre, int anios, String provincia, String familia) {
        this.id = id;
        this.nombre = nombre;
        this.anios = anios;
        this.provincia = provincia;
        this.apellido_familia = familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getFamilia() {
        return apellido_familia;
    }

    public void setFamilia(String familia) {
        this.apellido_familia = familia;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
