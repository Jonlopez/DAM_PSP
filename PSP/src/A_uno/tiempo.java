//package hilostiempo;
package A_uno;

import static java.lang.Thread.sleep;

public class tiempo
{
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        HilosTiempo prim = new HilosTiempo("Proceso1");
        HilosTiempo seg = new HilosTiempo("Proceso2");
         prim.setPriority(Thread.MAX_PRIORITY);
        seg.setPriority(Thread.MIN_PRIORITY);
        prim.start();
        seg.start();
        System.out.println ("En el main nunca se hace nada, todo lo hacen los hilos en RUN");
//        System.out.println(Thread.currentThread().getName());
    }
}
class HilosTiempo extends Thread{

//pasamos el nombre del hilo al constructor de la subclase HilosTiempo        
    public HilosTiempo (String str)
    {
        //Se pasa al constructor Thread el nombre del hilo mediante la palabra reservada SUPER
        super(str);
    }

    @Override
    public void run()
    {
        long a;
        for(int i=0;i<10;i++)
        {
            System.out.println("Hilo "+ i + ", " + getName());
            try{
                a = (long)(Math.random()*1000);
                sleep(a);
                System.out.println("Duerme el " + getName() + " " + a + " ms");
            }
            catch(InterruptedException e)
            {
            }
        }
        System.out.println("El " + getName() + " ha terminado");
    }
}