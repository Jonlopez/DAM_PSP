/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio1;

/**
 *
 * @author usuario1
 */
public class Ahorrador extends Thread {
    int numveces;
    Cuenta cuenta;
    /**
     *
     * @param cuenta objeto cuenta en el que guarda 1� cada vez
     * @param i n�mero de veces que ha de ahorrar
     */
    public Ahorrador(Cuenta cuenta, int i) {
        numveces = i;
        this.cuenta = cuenta;
    }
    @Override
    public void run() {
        for (int i = 0; i < numveces; i++) {
            cuenta.meter(10);
        }
    }
}