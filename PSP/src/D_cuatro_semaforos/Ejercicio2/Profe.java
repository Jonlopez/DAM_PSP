/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio2;

import D_cuatro_semaforos.Ejercicio2.Caja;
import java.util.concurrent.Semaphore;
/**
 *
 * @author josti
 */
public class Profe extends Thread
{
    Semaphore mutex;
    Caja total;
    public Profe(Semaphore mutex, Caja total) 
    {
        this.mutex = mutex;
        this.total = total;
    }
    
    public void run()
    {
        System.out.println("PROFE VERIFICANDO SI HAY JUGUETES");
        try
        {
            Thread.sleep(150);
            mutex.acquire();    //impide que ningun niño acceda a la caja
            while (total.getNumero()<=0)
            {
                total.setNumero(3);
                System.out.println("despues de rellenar la caja hay "+total.getNumero() + " juguetes.");            
            }
            mutex.release();    //libera el semaforo para que los niños puedan coger juguetes
        } catch (InterruptedException e){}
    }
}