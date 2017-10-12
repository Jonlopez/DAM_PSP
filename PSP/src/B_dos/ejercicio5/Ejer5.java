/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario1
 */
public class Ejer5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HiloPing PingThread=new HiloPing();
        HiloPong PongThread=new HiloPong();
        PingThread.start();
        //Con esto paramos la ejecucion del main, y solo se puede ejecutar el hiloping
        try {
            Thread.currentThread().sleep(100);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejer5.class.getName()).log(Level.SEVERE, null, ex);
        }
        PongThread.start();
    }
}