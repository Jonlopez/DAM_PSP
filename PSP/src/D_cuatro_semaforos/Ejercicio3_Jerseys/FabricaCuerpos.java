/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio3_Jerseys;

//import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author josti
 */
public class FabricaCuerpos extends Thread{
    Semaphore cestaCantidadCuerpos;
    Semaphore cestaCapacidadCuerpos;
    public FabricaCuerpos(Semaphore cestaCantidadCuerpos,Semaphore cestaCapacidadCuerpos)
    {
        this.cestaCantidadCuerpos=cestaCantidadCuerpos;
        this.cestaCapacidadCuerpos=cestaCapacidadCuerpos;
    }
    public void run()
    {
        try{
            while(Fabrica.fin==false)
            {
                cestaCapacidadCuerpos.acquire(); //restamos un sitio, en la cesta hay capacidad para un cuerpo
                sleep(100);
                System.out.println("Se ha fabricado un cuerpo");
                cestaCantidadCuerpos.release(); //añadimos +1 a la cantidad de cuerpos
                System.out.println("Semaforo cantidad a: " + cestaCantidadCuerpos.availablePermits());
            }
        }catch(InterruptedException e){}
    }
    public void parar() 
    {
            Fabrica.fin = true;
    }
}