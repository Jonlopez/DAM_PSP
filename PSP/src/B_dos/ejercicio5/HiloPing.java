/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio5;

/**
 *
 * @author usuario1
 * Para solucionarlo con modificar el tiempo del sleep deberia ser suficiente
 */
public class HiloPing extends Thread{
    public void run()
    {   
        try {
            for (int i = 0; i < 30; i++) {
                System.out.print("PING ");
                
                Thread.currentThread().sleep(301);
            }
      }catch(InterruptedException ex) {return;}
    }    
}