/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.ejemploMonitor;

/**
 *Ejemplo de Monitor sencillo. Encapsula una variable protegida por
*la abstraccion y posee una interfaz de dos metodos para
*incrementarla y decrementarla.
 * 
 */
public class Monitor {
    private static int dato; //recurso protegido
    public Monitor(int vInic) {
        dato = vInic;
    }

    public synchronized void inc() {
        while ((dato > 10)) {
            try {
                System.out.println("Hilo Sumador bloqueado");
                wait();
            } catch (InterruptedException e) {
            }
        }
        dato++;
         System.out.println("Hilo Sumador sumando");
         System.out.println(info());
        notifyAll();
    }
    
    public synchronized void dec() {
        while ((dato == 0)) {
            try {
                System.out.println("Hilo Restador bloqueado");
                wait();
            } catch (InterruptedException e) {
            }
        }
        dato--;
        System.out.println("Restando--------");
        System.out.println(info());
        
        notifyAll();
    }

    public synchronized String info() {
        return (new Integer(dato).toString());
    }
}