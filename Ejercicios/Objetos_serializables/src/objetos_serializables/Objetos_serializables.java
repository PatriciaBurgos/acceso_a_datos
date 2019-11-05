/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos_serializables;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

/**
 *
 * @author Patricia Burgos
 */
public class Objetos_serializables {

    public void escribir_obj () throws FileNotFoundException, IOException{
        
        File fichero = new File("FichAnimal.dat");//declara el fichero
        FileOutputStream fileout = new FileOutputStream(fichero,true);  //crea el flujo de salida
        //conecta el flujo de bytes al flujo de datos
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  

        ArrayList <Animal> animales = new ArrayList();
        Animal perro1 = new Animal("Coco", 5, "Granada", true);
        Animal gato1 = new Animal("Misy", 2, "Jaen", false);
        Animal leon1 = new Animal("Simba", 3, "Ciudad del Cabo", false);
        
        animales.add(perro1);
        animales.add(gato1);
        animales.add(leon1);
        
        for (int i=0;i<animales.size(); i++){ //recorro los arrays            
            dataOS.writeObject(animales.get(i)); //escribo el animal en el fichero 
        }     
        dataOS.close();  //cerrar stream de salida    
    }
    
    public void leer_obj() throws FileNotFoundException, IOException, ClassNotFoundException{
       
        File fichero = new File("FichAnimal.dat");
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
        
        Animal animales = new Animal();
        int i = 1;
        try {
            while (true) { // lectura del fichero
                animales = (Animal) dataIS.readObject(); // leer una Persona
                System.out.print(i + "=>");
                i++;
                if(animales.isFamilia()==true){
                    System.out.printf("Nombre: %s, Edad: %d , Provincia: %s, Familia: si %n",
                    animales.getNombre(),animales.getAnios(), animales.getProvincia());
                } else {
                    System.out.printf("Nombre: %s, Edad: %d , Provincia: %s, Familia: no %n",
                    animales.getNombre(),animales.getAnios(), animales.getProvincia());
                }                
            }
        } catch (EOFException eo) {
                System.out.println("FIN DE LECTURA.");
        } catch (StreamCorruptedException x) {
        }
        dataIS.close(); // cerrar stream de entrada
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        Objetos_serializables obj = new Objetos_serializables();
        
        obj.escribir_obj();
        obj.leer_obj();
    }
    
}
