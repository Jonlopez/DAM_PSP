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
public class Nino extends Thread
{
    private String nombre;
    private Semaphore bandeja;
    private Semaphore mesa;
    private Semaphore fregadero;

    public Nino(String nombre, Semaphore bandeja, Semaphore mesa, Semaphore fregadero)
    {
        this.nombre = nombre;
        this.bandeja = bandeja;
        this.mesa = mesa;
        this.fregadero = fregadero;
    }

    @Override
    public void run()
    {
       busy(); // Sale un perro caliente
       
       try {
            bandeja.acquire();

            System.out.println(nombre +" Toma un perrito caliente");
            busy();// Tiempo que tarda en agarrar el perro caliente
            
            mesa.acquire();
            System.out.println(nombre +" Se sienta a comer");
            bandeja.release();

            
            busy(); // Tiempo que tarda sentado, comiendo
            mesa.release();

            fregadero.acquire();
            } catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(nombre +" Lava su plato en el fregadero");
            busy(); // Tiempo que tarda fregando 
            fregadero.release();
       
       System.out.println(nombre +" Termino");
       }

       private int random(int n)
       {
           return (int) Math.round(n * Math.random());
       }
       private void busy()
       {
           try
           {
               sleep(random(1000));
           } catch (InterruptedException e){}
       }
}