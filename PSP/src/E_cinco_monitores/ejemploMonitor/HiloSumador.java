/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.ejemploMonitor;

/**
 *
 * @author usuario1
 */
public class HiloSumador extends Thread {

    private Monitor moni;

    public HiloSumador(Monitor ref) {
        moni = ref;
    }

    public void run() {
//        for (;;) {
        while(true)
        {
            moni.inc();
            moni.toString();
        }
//        }
    }
}
    

