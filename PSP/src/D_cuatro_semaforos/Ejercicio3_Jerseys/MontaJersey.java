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
public class MontaJersey extends Thread{
    Semaphore cestaCantidadCuerpos;
    Semaphore cestaCapacidadCuerpos;
    Semaphore cestaCantidadMangas;
    Semaphore cestaCapacidadMangas;
    public MontaJersey(Semaphore cestaCantidadCuerpos,Semaphore cestaCapacidadCuerpos,Semaphore cestaCantidadMangas,Semaphore cestaCapacidadMangas)
    {
        this.cestaCantidadCuerpos=cestaCantidadCuerpos;
        this.cestaCapacidadCuerpos=cestaCapacidadCuerpos;
        this.cestaCantidadMangas=cestaCantidadMangas;
        this.cestaCapacidadMangas=cestaCapacidadMangas;
    }
    public void run()
    {
        try{
            while(Fabrica.fin==false)
            {
                cestaCantidadCuerpos.acquire(); //coge cuerpo
                System.out.println("Se ha cogido la pieza CUERPO");
                sleep(100);
                cestaCapacidadCuerpos.release();    //deja sitio a otro cuerpo
                cestaCantidadMangas.acquire(2); //coge dos mangas
                System.out.println("Se han cogido 2 MANGAS");
                sleep(100);
                cestaCapacidadMangas.release(2);    //deja sitio a otras 2 mangas
                sleep(200); //deja tiempo para montar el jersey
                System.out.println("Se ha creado un JERSEY");
            }
            }catch(InterruptedException e){}
    }
    public void parar()
    {
        Fabrica.fin=true;
    }
}
