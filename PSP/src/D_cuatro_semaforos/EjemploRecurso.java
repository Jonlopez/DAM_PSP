/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author josti
 */
public class EjemploRecurso {

    public static void main(String args[])
    {
        Semaphore semaphore = new Semaphore(2);//Indica que dos threads pueden acceder al recurso al mismo tiempo.  
          
//          PARA SABER CUANTOS ACCESOS HAY DISPONIBLES
          System.out.println(semaphore.availablePermits());
           try
          {   
          //Si el contador es cero el thread se duerme, de lo contrario se resta 1 y obtiene el acceso  
           semaphore.acquire(); 
           System.out.println(semaphore.availablePermits());
           System.out.println("Comienza el thread " + Thread.currentThread().getName() + " tiene el lock");                 
           
           Thread.sleep(10000);  
           } catch (InterruptedException e) {  
                e.printStackTrace();  
           }  
           System.out.println("Termina el thread " + Thread.currentThread().getName() + " tiene el lock");
           semaphore.release();//Libera el semaphore e incrementa el contador  
           System.out.println(semaphore.availablePermits());
    }
}