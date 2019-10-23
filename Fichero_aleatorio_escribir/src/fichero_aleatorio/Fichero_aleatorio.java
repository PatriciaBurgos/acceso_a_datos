/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichero_aleatorio;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Patricia Burgos
 */
public class Fichero_aleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fichero = new File("AleatorioEmpleado.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        
        Empleado empleado1 = new Empleado(20,"Jimenez",10,1000.5);
        Empleado empleado2 = new Empleado(25,"Suárez", 30, 968.6);
        Empleado empleado3 = new Empleado (32, "Hernández",15, 1237);
        Empleado empleado4 = new Empleado (44, "Rodriguez", 30, 972.57);
        
        ArrayList <Empleado> array_empleado = new ArrayList <Empleado>();
        array_empleado.add(empleado1);
        array_empleado.add(empleado2);
        array_empleado.add(empleado3);
        array_empleado.add(empleado4);
        
        //Escribir en el fichero
        
        StringBuffer buffer = null;
        int logitud_array = array_empleado.size();
        
        for (int i=0;i<logitud_array; i++){ //recorro los arrays          	  
            file.writeInt(array_empleado.get(i).getId()); 
            buffer = new StringBuffer( array_empleado.get(i).getApellido() );      
            buffer.setLength(10); //10 caracteres para el apellido
            file.writeChars(buffer.toString());//insertar apellido
            file.writeInt(array_empleado.get(i).getDepartamento());//insertar departamento
            file.writeDouble(array_empleado.get(i).getSalario());//insertar salario
        }     
        file.close();  //cerrar fichero 
    }
}
