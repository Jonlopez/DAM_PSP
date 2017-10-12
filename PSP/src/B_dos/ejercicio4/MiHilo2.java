/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio4;

/**
 *
 * @author usuario1
 */
public class MiHilo2 implements Runnable{
   
    
    public void run () {
        for (int i=0;i<100;i++)
            if((i % 2)==0)
            {
                System.out.println (i+1);
            }
       System.out.print("La prioridad dentro del run de hilo2 es: "+Thread.currentThread().getPriority()+ "\n");
    }
}