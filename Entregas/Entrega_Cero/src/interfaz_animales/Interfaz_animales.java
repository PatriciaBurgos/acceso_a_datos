/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz_animales;

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
public class Interfaz_animales {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        Vista1 vista1 = new Vista1();
        vista1.setVisible(true);
    }
    
}
