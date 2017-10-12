/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.ejemploMonitor29;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josti
 */
public class Hilo implements Runnable {

    /**
     * @param args the command line arguments
     */
    private int id;
    private static Random cerrojo=new Random();
    private static int cont=0;
    
    public Hilo(int id)
    {
        this.id=id;
    }
    public static void main(String[] args) 
    {
        Runtime r=Runtime.getRuntime();
        int numHilos=r.availableProcessors();
        Thread[] hilos=new Thread[8];
        
        for (int i = 0; i < 8; i++) 
        {
            Hilo run=new Hilo(i);
            hilos[i]=new Thread(run);
            hilos[i].start();
        }
        for (int i = 0; i < 8; i++) 
        {
            try {
                hilos[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Termina el hilo principal. Cont=" + cont);
    }
    public void run()
    {
        synchronized(cerrojo)
        {
//           
            while(id!=cont) 
                /*Si en vez de while pongo IF, hay un hilo que se quedará esperando dentro del if. 
                Ese hilo cuando se despierte no comprobará la condición del IF, seguirá donde se quedó, 
                por lo que escribirá en pantalla lo que le corresponda. (No respetará el orden)
                */
            {
                try{
                    cerrojo.wait();
                }catch(Exception e){}
            }
            System.out.println("Soy el hilo:" + id);
            cont++;
            cerrojo.notifyAll();
        }
    }                   
}

// while(id!=cont)
//            {
//                try{
//                    cerrojo.wait();
//                }catch(Exception e){}
//            }