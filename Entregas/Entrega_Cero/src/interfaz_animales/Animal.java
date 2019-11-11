/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz_animales;

import java.io.Serializable;

/**
 *
 * @author Patricia Burgos
 */
public class Animal implements Serializable{
    private String nombre;
    private int anios;
    private String provincia;
    private boolean familia;

    public Animal() {
        this.nombre = "";
        this.anios = 0;
        this.provincia = "";
        this.familia = false;
    }
    
    public Animal(String nombre, int anios, String provincia, boolean familia) {
        this.nombre = nombre;
        this.anios = anios;
        this.provincia = provincia;
        this.familia = familia;
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

    public boolean isFamilia() {
        return familia;
    }

    public void setFamilia(boolean familia) {
        this.familia = familia;
    }
}
