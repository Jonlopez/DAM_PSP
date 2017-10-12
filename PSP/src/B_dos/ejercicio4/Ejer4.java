/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio4;

/**
 *
 * @author usuario1
 */
public class Ejer4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MiHilo par = new MiHilo();
        MiHilo2 impar = new MiHilo2();
        Thread t1 = new Thread(par);
        Thread t2 = new Thread(impar);
        System.out.println("Estado hilo1: " + t1.getState());//PAra conocer el estado del hilo
        t1.setPriority(1);
       
        t1.start();
        System.out.println("estado de hilo1: " + t1.getState());
        t2.start();
        System.out.println("Prioridad de hilo1: " + t1.getPriority());

        System.out.println("Prioridad de hilo2: " + t2.getPriority());
         System.out.println("estado de hilo1: " + t1.getState());
    }
}