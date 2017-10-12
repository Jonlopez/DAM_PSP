/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio8;

/**
 *
 * @author usuario1
 */
public class GeneraEnteros extends Thread 
{    
    int n, tiempo;
    String nombre;
    public GeneraEnteros(int valorN, String nombreHilo, int retardo) 
    {
        n = valorN;
        nombre = nombreHilo;
        tiempo=retardo; 
    }

    public void run() 
    {
        for (int i = 0; i < n; i++) 
        {
            System.out.println("Numero "+i+ " en " + nombre);
            try {
                sleep(tiempo);
            } catch (InterruptedException e) {
            System.out.println("Interrupcion "+ nombre);}
        }
        System.out.println("Termina "+nombre );
    }    
}