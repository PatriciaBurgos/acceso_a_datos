/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichero_aleatorio_leer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Patricia Burgos
 */
public class Fichero_aleatorio_leer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fichero = new File("AleatorioEmpleado.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
   
        int  id, dep;    
        Double salario;	
        char apellido[] = new char[10]; 

        for(int posicion = 0; file.getFilePointer() != file.length();posicion+=36){  
            
            file.seek(posicion); //nos posicionamos en posicion
            id = file.readInt();   // obtengo id de empleado	  	  
      
            //recorro uno a uno los caracteres del apellido
            for (int i = 0; i < apellido.length; i++) {         
               apellido[i] = file.readChar(); 
            }

            //convierto a String el array
            String apellidos = new String(apellido); 
            dep = file.readInt();//obtengo departamento
            salario = file.readDouble(); //obtengo salario

            if(id >0){
                System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",
                    id, apellidos.trim(), dep, salario);     
            }
        }
        file.close();  //cerrar fichero 
    }    
}
