/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.EjercicioPerritoCaliente;

import java.util.concurrent.Semaphore;

/**
 *
 * @author josti
 */
public class SemaforoPerritoCaliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore bandeja = new Semaphore(1);// Simula la bandeja de perros
        Semaphore mesa = new Semaphore(3);// Simula la mesa donde se come
        Semaphore fregadero = new Semaphore(2);// Simula el Fregadero donde se limpia

        for (int i=1; i<=10; i++)
        {
            //así solo crearíamos un hilo
//            Nino n=new Nino("Niño "+ i, Bandeja, Mesa, Fregadero);
            new Nino("Niño "+ i, bandeja, mesa, fregadero).start();
        }
    }
}