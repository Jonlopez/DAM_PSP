/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author josti
 */

public class Lector extends Thread {
    private Semaphore semaforo;
    public Lector(String nombre, Semaphore s) {
        super(nombre);
        this.semaforo = s;
    }
    public void run() {
        System.out.println(getName() + " :Intentando leer");
        try {
            semaforo.acquire();
        } catch (InterruptedException e) {e.printStackTrace();}
        
        
        try {
            sleep((int) (Math.random() * 50));
        } catch (InterruptedException e) {e.printStackTrace();}
        System.out.println(getName() + " :ya he leido");
        semaforo.release();
    }
}