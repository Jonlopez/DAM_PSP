/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.Sincro31;

import java.util.Random;

/**
 *
 * @author josti
 */
public class Hilo implements Runnable{
    private int id;
    private static Random cerrojoA=new Random();
    private static Thread cerrojoB=new Thread();
    
    public Hilo(int id)
    {
        this.id=id;
    }
    public static void main(String[] args) {
        Runtime run=Runtime.getRuntime();
        int numHilos=run.availableProcessors();
        
        Thread[] hilos=new Thread[numHilos];
        
        for (int i = 0; i < hilos.length; i++) 
        {
            Hilo runnable=new Hilo(i);
            hilos[i]=new Thread(runnable);
            hilos[i].start();
        }
        for (int i = 0; i < hilos.length; i++) 
        {
            try{
                hilos[i].join();
            }
            catch(Exception e){}
        }
        System.out.println("Soy el hilo principal");
    }
    
    public void run()
    {
        if(id%2==0)
        {
            synchronized(cerrojoA)
            {
                mostrarA();
            }
        }
        else
        {
            synchronized(cerrojoB)
            {
                mostrarB();
            }
        }
    }
    private void mostrarA()
    {
        synchronized(cerrojoB)
        {
            System.out.println("Soy el hilo: " + id);
        }
    }
    private void mostrarB()
    {
        synchronized(cerrojoA)
        {
            System.out.println("Soy el hilo: " + id);
        }
    }   
}