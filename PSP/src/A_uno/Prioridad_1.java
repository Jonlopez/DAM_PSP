/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_uno;

import A_uno.Prioridad;

/**
 *
 * @author josti
 */
public class Prioridad_1 implements Runnable
{
    String palabra;
    
    public Prioridad_1(String _palabra)
    {
        palabra = _palabra;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Prioridad a1 = new Prioridad("a1");
        Prioridad a2 = new Prioridad("a2");
        Prioridad a3 = new Prioridad("a3");
        Thread t1 = new Thread(a1,"hola");
        Thread t2 = new Thread(a2);
        Thread t3 = new Thread(a3);
        t1.start();
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.start();
//                t2.start(); Da igual que adelantemos la llamada a t2, ejecuta las sentencias en el orden que quiere
        System.out.println("Prioridad de t1 o " +t1.getName()+" es " +t1.getPriority());
//        System.out.println("nombre de t1 " + t1.getName());
        t3.start();
        System.out.println("Prioridad de t2 o "+ t2.getName() + " es " + t2.getPriority());
        
////////////////////        
        Thread.currentThread();
//        System.out.println("current " +  Thread.currentThread().toString());
        t1.yield();
//        System.out.println("current " +  Thread.currentThread().getName());
//        try
//        {
//        t2.sleep(100);
//        System.out.println("ZzZzZzZz....");
//        }catch(InterruptedException e){}

    }

    @Override
    public void run() {

//QUITAR TRY PARA VER QUE PASA        
        try
        {
            for(int i=0;i<10;i++)
            System.out.println(palabra);
        }
        catch(Exception e)
        {
        }
    }   
}