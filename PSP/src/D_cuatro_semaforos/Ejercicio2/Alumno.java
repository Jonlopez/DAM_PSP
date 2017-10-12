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
public class Alumno extends Thread 
{
    Semaphore mutex;
    Caja total;
    public Alumno(Semaphore mutex, Caja total) 
    {
        this.mutex = mutex;
        this.total = total;
    }
    public void run()
    {
        System.out.println("niño jugando");
        try
        { //--niños jugando
            Thread.sleep(100);
            mutex.acquire();    //coge el semáforo con la intención de coger un juguete
            while (total.getNumero()<=0) //--no hay juguetes
            {
                System.out.println("Nro juguetes: "+total.getNumero());
                mutex.release();    //sueltan el semaforo, asi la madre puede reponer
                System.out.println("NIÑO ESPERANDO POR JUGUETES");
                sleep(1000);
                mutex.acquire();    //vuelven a coger el semaforo porque ya estará llena la caja
            }
            System.out.println("Nro juguetes antes: "+total.getNumero());
            System.out.println("niño coge un juguete");
            total.setNumero(total.getNumero()-1);
            System.out.println("Nro juguetes despues: "+total.getNumero());
            mutex.release();    //despues de haber cogido un juguete, suelta el semaforo
        } catch (InterruptedException e){}
    }
}