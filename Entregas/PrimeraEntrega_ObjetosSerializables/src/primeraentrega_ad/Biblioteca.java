/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeraentrega_ad;
import java.io.Serializable;
/**
 *
 * @author Patricia Burgos
 */
public class Biblioteca implements Serializable{
    private int id_biblioteca;
    private String nombre;
    private String telefono;
    private String direccion;
    private int id_ciudad;
   
    public Biblioteca() {
        this.nombre = "";
        this.telefono = "";
        this.direccion = "";
        this.id_ciudad = 0;
    }
    
    public Biblioteca(int id_biblioteca, String nombre, String telefono, String direccion, int id_ciudad) {
        this.id_biblioteca = id_biblioteca;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.id_ciudad = id_ciudad;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
}
