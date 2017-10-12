/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario1
 */
public class MiHilo extends Thread{
        String palabra;
    public MiHilo(String name) {
        palabra=name;
    }
    public void run()
    {
        for(int i=0;i<10;i++){

            System.out.println(palabra);
            try {
                Thread.sleep(1212);
            } catch (InterruptedException ex) {
                Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}