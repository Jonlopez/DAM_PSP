/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author usuario1
 */
public class Cuenta {
    private int saldo;
  
    public Cuenta(int cantidad) 
    {
        saldo = cantidad;
    }
    public synchronized void meter(int cantidad) {
//        while(saldo>=250){
//            try {
//                System.out.println("Ahorrador bloqueado");
//                wait();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        saldo = saldo + cantidad;
        System.out.println("Ahorrando- saldo: " + saldo);
        notifyAll();
    }

    public synchronized void sacar(int cantidad) 
    {
        while ((saldo < cantidad) ) 
        {
            try {
                System.out.println(" \tNo hay saldo para gastar");
                wait();
            } catch (InterruptedException e) {
            }
        }
            saldo = saldo - cantidad;
            System.out.println("Gastando- saldo: " + saldo);
            notifyAll();
    }

    public int getSaldo() {

        return saldo;
    }   
}