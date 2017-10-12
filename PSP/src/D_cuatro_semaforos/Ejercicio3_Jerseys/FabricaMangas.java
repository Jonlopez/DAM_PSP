/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio3_Jerseys;

import java.util.concurrent.Semaphore;

/**
 *
 * @author josti
 */
public class FabricaMangas extends Thread
{
    Semaphore cestaCantidadMangas;
    Semaphore cestaCapacidadMangas;
    public FabricaMangas(Semaphore cestaCantidadMangas,Semaphore cestaCapacidadMangas)
    {
        this.cestaCantidadMangas=cestaCantidadMangas;
        this.cestaCapacidadMangas=cestaCapacidadMangas;
    }
    public void run()
    {
        try{
            while(Fabrica.fin==false)
            {
                cestaCapacidadMangas.acquire();
                sleep(100);
                System.out.println("Se ha fabricado una manga");
                cestaCantidadMangas.release();
            }
        }catch(InterruptedException e){}
    }
    public void parar()
    {
        Fabrica.fin=true;
    }
}