/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_uno;

/**
 *
 * @author josti
 */
public class Prioridad implements Runnable
{
//    String palabra;
//    
//    public Prioridad(String _palabra)
//    {
//        palabra = _palabra;
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Prioridad a1 = new Prioridad();
        Prioridad a2 = new Prioridad();
        Prioridad a3 = new Prioridad();
        Thread t1 = new Thread(a1,"a1");
        Thread t2 = new Thread(a2,"a2");
        Thread t3 = new Thread(a3,"a3");
        
        System.out.println("Vive el hilo 1?: " + t1.isAlive());
        t1.start();
        System.out.println("Vive el hilo 1?: " + t1.isAlive());
        
        t1.suspend();
        t1.setPriority(1);
        t2.start(); //Da igual que adelantemos la llamada a t2, ejecuta las sentencias en el orden que quiere
        System.out.println("Prioridad de hilo 1 o " +t1.getName()+" es " +t1.getPriority());
        t3.start();
        System.out.println("Prioridad de hilo 2 o "+ t2.getName() + " es " + t2.getPriority());
        t1.resume();
    }

    Prioridad(String a1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Prioridad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() 
    {   
        try
        {
            System.out.println("Está vivo el hilo " + Thread.currentThread().getName() +"?: "+ Thread.currentThread().isAlive());
            for(int i=0;i<10;i++)
            {
                System.out.println("Iteración " + i +": " + Thread.currentThread().getName());
                Thread.yield();
                System.out.println("yield");
//                System.out.println("Iteración " + i +": " + Thread.currentThread().getName());
//                System.out.println("Hilo que se está ejecutando: " + Thread.currentThread().getName());
                
                    Thread.sleep(10000);

                if(i==4)
                {
//                    Thread.currentThread().suspend();
//                    System.out.println("suspendido");
//                    Thread.currentThread().resume();
                }
            }
        }
        catch(Exception e)
        {
        }
    }
}