/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.ejemplo_Sincro1;

import static java.lang.Thread.sleep;

/**
 *
 * @author josti
 */
public class HiloB extends Thread
{
    private Contador contador;
    public HiloB(String n, Contador c)
    {
        setName(n);
        contador=c;
    }
    @SuppressWarnings("SynchronizeOnNonFinalField")
    public void run()
    {
        //COMENTAR LAS SINCRONIZACIONES DE LOS 2 HILOS Y VER QUE PASA
        synchronized(contador)
        {
            for (int j=0;j<300;j++)
            {
                contador.decrementa();
                try
                {
                    //cambiar los milisegundos del sleep y ver que pasa
                    sleep(100);
                }
                catch(InterruptedException e){}
            }
            System.out.println(getName() + " contador vale " +  contador.getValor());
        }
    }
}
