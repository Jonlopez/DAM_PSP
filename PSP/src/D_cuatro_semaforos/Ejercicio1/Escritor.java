/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio1;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author josti
 */
public class Escritor extends Thread 
{
    private Semaphore semaforo;
    public Escritor(String nombre, Semaphore s) 
    {
        super(nombre);
        this.semaforo = s;
    }
    public void run() 
    {
        //SE EJECUTAN LOS HILOS DE LA COLA EN ORDEN DE LLEGADA?? FIFO???
        System.out.println(getName() + " : Intentando escribir");
        try {
//            while(semaforo.availablePermits()!=10)
//            {
//                System.out.println("available: " + semaforo.availablePermits());
//
//            }
//            System.out.println("available: " + semaforo.availablePermits());
            semaforo.acquire(10);
        } catch (InterruptedException e) {e.printStackTrace();}
        
        System.out.println(getName() + " : Ya he escrito");
        try 
        {
            sleep((int) (Math.random() * 50));
        } catch (InterruptedException e) {e.printStackTrace();}
        
        semaforo.release(10);
    }
}