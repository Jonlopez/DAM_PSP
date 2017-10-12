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
public class Niño extends Thread 
{
    Semaphore profe;
    Semaphore mutex;
    Caja total;
    
    public Niño(Semaphore profe, Semaphore mutex, Caja total) 
    {
        this.profe = profe;
        this.mutex=mutex;
        this.total = total;
    }
    public void run () 
    {
        System.out.println("niño jugando");
        try 
        {
            mutex.acquire(); //Aquí evitamos que dos procesos comprueben el número de juguetes a
                            //la vez, ya que podría darse una falsa lectura

            while (total.getNumero()<=0)
            { //Si no hay juguetes...
                System.out.println("Nro juguetes: "+total.getNumero());
                System.out.println("No hay juguetes");
                
                mutex.release();
                sleep(1000);

                profe.release(); //Desbloquea a la profe para que rellene
                //para poder acceder a la seccion critica se debe ejecutar profe.release()
                
                mutex.acquire();
            }
                System.out.println("niño coge un juguete");
                total.setNumero(total.getNumero()-1);//un juguete menos } }
                System.out.println("Nro juguetes despues: "+total.getNumero());

            try
            {
                sleep((1000));
            } catch (InterruptedException e){}
            
            mutex.release();
        } catch(InterruptedException ex) 
        {
            Logger.getLogger(Niño.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}