/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio2;

import javax.swing.JOptionPane;

/**
 *
 * @author usuario1
 */
public class Ejer2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        String nombre1=JOptionPane.showInputDialog("Introduzca nombre primer hilo");
        String nombre2=JOptionPane.showInputDialog("Introduzca nombre segundo hilo");
        String nombre3=JOptionPane.showInputDialog("Introduzca nombre tercer hilo");
        System.out.println("Creamos el hilo");
        MiHilo hilo1= new MiHilo(nombre1);
        MiHilo hilo2= new MiHilo(nombre2);
        MiHilo hilo3= new MiHilo(nombre3);
        Thread t1=new Thread(hilo1);
        Thread t2=new Thread(hilo2);
        Thread t3=new Thread(hilo3);
//        t1.getState();
        System.out.println("Lanzamos ejecucion del hilo");
        t1.start();
//        t1.getState();
        t2.start();
        t3.start();
        System.out.println(Thread.currentThread().getName());
        System.out.println("Termina programa principal");
    }
}
