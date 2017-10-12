/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario1
 */
public class Ejer3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Empieza la aplicacion");

//            MiHilo hilo1=new MiHilo();      
//            MiHilo hilo2=new MiHilo();
//            MiHilo hilo3=new MiHilo();
            
            MiHiloRunnable h1=new MiHiloRunnable();      
            MiHiloRunnable h2=new MiHiloRunnable();
            MiHiloRunnable h3=new MiHiloRunnable();
            
            Thread hilo1=new Thread(h1);
            Thread hilo2=new Thread(h2);
            Thread hilo3=new Thread(h3);
            
            hilo1.setName("prueba");
            hilo2.setName("Campeon");
            hilo3.setName("java");
            
            hilo1.start();
            hilo2.start(); 
            hilo3.start();
            System.out.println("Termina la aplicacion");
    }
}