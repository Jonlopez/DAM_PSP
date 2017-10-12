/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio1;

import javax.swing.JOptionPane;
import javax.swing.JDialog;

/**
 *
 * @author usuario1
 */
public class Ejer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre1=JOptionPane.showInputDialog("Introduzca nombre primer hilo");
        System.out.println("Creamos el hilo");
        MiHilo hilo= new MiHilo(nombre1);
        System.out.println("Lanzamos ejecucion del hilo");
        hilo.start();
        System.out.println("Termina programa principal");
    }
}