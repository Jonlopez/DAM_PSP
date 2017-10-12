/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_uno;

import java.util.Random;

/**
 *
 * @author josti
 */
public class Hilo2 extends Thread{
    private static int tamano=8;
    private static int[] vec=new int[tamano];
    private int ini, fin;
    public static double t_inicio, t_fin;
    
    public Hilo2(int ini, int fin)
    {
        this.ini=ini;
        this.fin=fin;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random(System.nanoTime());
        for (int i = 0; i < vec.length; i++) 
        {
            vec[i]= r.nextInt(10); //solo introduce valores entre 0 y 10
//            System.out.println(r.nextInt(10) + " contra " + r.nextInt());
        }
        t_inicio=System.nanoTime();
        Hilo2 h1=new Hilo2(0,4);
        Hilo2 h2=new Hilo2(4,8);
        h1.start();
        h2.start();
        try{
            h1.join();
            h2.join();
        }catch(Exception e){}
      
        t_fin=System.nanoTime() - t_inicio;
        System.out.println(t_fin/1000000 + " milisegundos");
    }
    public void run()
    {
        for (int i = ini; i < fin; i++) 
        {
            vec[i]=vec[i]*10;
            System.out.println(Thread.currentThread().getName() + " iteración: " + i);
        }
    }
}