/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.Sincro28;

/**
 *
 * @author josti
 */
public class Sincro28 implements Runnable
{
    public static int cont=0;
    public static void main(String[] args) 
    {
        Thread hilo[]=new Thread[2];
        
        for (int i = 0; i < hilo.length; i++) 
        {
            Sincro28 run=new Sincro28(); //esto podríamos ponerlo fuera del for
            hilo[i]=new Thread(run);
            hilo[i].start();
        }
        try{
            for (int i = 0; i < hilo.length; i++) 
            {
                hilo[i].join();
            }
        }catch(Exception e){}
        System.out.println(cont);
    }
    private static Object obj=new Object();
    @Override
    public void run() 
    {
//        Ver la diferencia entre usar synchronized y no usar
        synchronized(obj)
        {
            for (int i = 0; i < 20000; i++) 
            {
                cont++;
            }
        }
//        De los hilos que están en la cola, cuando se abre el cerrojo se despiertan todos y entra al cerrojo el más rápido
//        Este codigo que sigue sería menos eficiente:
//        for (int i = 0; i < 20000; i++) 
//        {
//            synchronized(obj)
//            {
//                cont++;
//            }
//        }
    }
}