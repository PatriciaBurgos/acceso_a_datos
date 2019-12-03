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
public class Persona {
    private int id_persona;
    private String DNI;
    private String nombre;
    private String edad;
    private String ciudad_natal;
    private int id_libro;

    public Persona() {
        this.DNI = "";
        this.nombre = "";
        this.edad = "";
        this.ciudad_natal = "";
        this.id_libro = 0;
    }
    
    public Persona(int id_persona, String DNI, String nombre, String edad, String ciudad_natal, int id_libro) {
        this.id_persona = id_persona;
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad_natal = ciudad_natal;
        this.id_libro = id_libro;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCiudad_natal() {
        return ciudad_natal;
    }

    public void setCiudad_natal(String ciudad_natal) {
        this.ciudad_natal = ciudad_natal;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }
}
