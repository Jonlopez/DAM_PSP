/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio2_2_semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josti
 */
public class Profe extends Thread 
{
    Semaphore profe;
    Semaphore mutex;
    Caja total;
    
    public Profe(Semaphore profe, Semaphore mutex, Caja total) 
    {
        this.profe = profe;
        this.mutex=mutex;
        this.total = total;
    }
    public void run()
    {
        System.out.println("Profe verifica si hay juguetes");
        try 
        {
            profe.acquire(); //Aquí se bloquea el semáforo profe. Se pone a 0
            System.out.println("entra el profe a rellenar");
            mutex.acquire();//impide que ningun niño acceda a la caja
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(Profe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        total.setNumero(3); //Relleno la caja de juguetes
        System.out.println("despues de rellenar la caja hay "+total.getNumero() + " juguetes.");
        try
        {
            sleep((100));
        } catch (InterruptedException e){}
        
        mutex.release(); //El semáforo mutex impide que 2 procesos comprueben la variable
    }
}