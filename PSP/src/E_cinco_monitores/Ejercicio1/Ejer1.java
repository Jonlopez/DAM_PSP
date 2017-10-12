/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio1;

/**
 *
 * @author usuario1
 */
public class Ejer1 {

    static final int SALDOINICIAL = 20;
    static final int NUMVECES = 10;
    public static final int NUMHILOS = 2;

    /**
     * @param args
     */
    public static void main(String[] args) {
        Cuenta cuenta;
        Ahorrador ahorradores[] = new Ahorrador[NUMHILOS];
        Gastador gastadores[] = new Gastador[NUMHILOS];
        cuenta = new Cuenta(SALDOINICIAL);
        for (int i = 0; i < NUMHILOS; i++) {
            ahorradores[i] = new Ahorrador(cuenta, NUMVECES);
            gastadores[i] = new Gastador(cuenta, NUMVECES);
        }
        for (int i = 0; i < NUMHILOS; i++) {
            ahorradores[i].start();
            gastadores[i].start();
        }
        for (int i = 0; i < NUMHILOS; i++) {
            try {
                ahorradores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < NUMHILOS; i++) {
            try {
                gastadores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        cuenta.finalizar();
        System.out.println("el saldo final de la cuenta es: "+cuenta.getSaldo());      
    }
}