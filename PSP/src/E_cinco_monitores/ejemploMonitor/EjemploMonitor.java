/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.ejemploMonitor;

/**
 *
 * @author usuario1
 */
public class EjemploMonitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       {
            Monitor ejemplo = new Monitor(10);
            new HiloSumador(ejemplo).start();
            new HiloRestador(ejemplo).start();
            new HiloRestador(ejemplo).start();
            new HiloRestador(ejemplo).start();

        }
    }
}
