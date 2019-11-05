/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscar_en_fichero;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Patricia Burgos
 */
public class Buscar_en_fichero {

    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        if (args.length <2){
            System.out.println("Indicar por favor el nombre del fichero y una cadena para buscar.");
            return;
        }
        
        String nomFich = args[0];
        String cadena = "";
        int j = 0;
        for  (int i=1; i<args.length-1; i++){
            cadena += args[i] + (" ");
            j++;
        }
        cadena += args[j+1];
        System.out.println(cadena);
        
        
        try (BufferedReader fbr = new BufferedReader (new FileReader(nomFich))){
            int i = 0;
            String linea = fbr.readLine();
            
            while (linea != null) {            
                
                if (linea.indexOf(cadena) < 0){
                    System.out.println("No se ha encontrado");
                }else {
                    System.out.println("*********");
                    System.out.println("Se ha encontrado la cadena: "+ cadena);
                    System.out.println("La linea de la palabra es: "+ i);
                    System.out.println("La columna de la palabra es: " +linea.indexOf(cadena));
                }
                linea=fbr.readLine();
                i++;
            }
        } catch (FileNotFoundException e){
            System.out.println("No existe el fichero " + nomFich);          
        } catch (IOException e){
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
