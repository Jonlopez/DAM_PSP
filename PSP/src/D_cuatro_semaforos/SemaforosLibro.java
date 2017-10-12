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
public class SemaforosLibro extends Thread
{
    /**
     * @param args the command line arguments
     */
    private static Semaphore mutex = new Semaphore(1);
    private static int i=0;
    boolean running=true;
    
    @Override
    public void run()
    {
        while (running)
        {
            try
            {
                mutex.acquire();
                System.out.println(mutex.availablePermits());
                i++;
                System.out.println("valor de i: " + i);
                mutex.release();
            }
            catch(InterruptedException e){}
        }
    }

    public static void main(String[] args) {
        System.out.println("Comienza el programa principal con i: " + i);
        SemaforosLibro hilo=new SemaforosLibro();
        hilo.start();
        try{
            System.out.println("Empieza con el semaforo a: " + mutex.availablePermits());
//            mutex.wait(100,10);
        }
        catch(Exception e){}
        System.out.println("Termina programa principal con i: " + i);
    }   
}