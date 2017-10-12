/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package B_dos.ejercicio5;

/**
 *
 * @author usuario1
 */
public class HiloPong extends Thread{
    public void run(){

        try {
            for (int i = 0; i < 30; i++) {
                System.out.print("pong ");
//               yield(); //NO FUNCIONA CON YIELD, PORQUE DENTRO DE ESTE RUN SOLO SE EJECUTA ESTE HILO
                Thread.currentThread().sleep(300);
            }
      }catch(InterruptedException ex) {return;}   
    }
}