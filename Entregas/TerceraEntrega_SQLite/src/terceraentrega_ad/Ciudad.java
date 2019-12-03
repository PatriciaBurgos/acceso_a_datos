/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terceraentrega_ad;

/**
 *
 * @author Patricia Burgos
 */
public class Ciudad {
    private int id_ciudad;
    private String nombre;
    private String pais;
    private int num_habitantes;

    public Ciudad(){
        this.nombre = "";
        this.pais = "";
        this.num_habitantes = 0;
    }
    public Ciudad(int id_ciudad, String nombre_ciudad, String pais, int num_habitantes) {
        this.id_ciudad = id_ciudad;
        this.nombre = nombre_ciudad;
        this.pais = pais;
        this.num_habitantes = num_habitantes;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNum_habitantes() {
        return num_habitantes;
    }

    public void setNum_habitantes(int num_habitantes) {
        this.num_habitantes = num_habitantes;
    }
}
