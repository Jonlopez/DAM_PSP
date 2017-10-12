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
public class HiloA extends Thread
{
    private Contador contador;
    public HiloA(String n, Contador c)
    {
        setName(n);
        contador=c;
    }
    public void run()
    {
//        cuando un hilo intenta entrar al bloque sincronizado le pregunta si hay algún otro hilo 
//        ejecutando el bloque sincronizado con ese objeto (que lo tenga bloqueado)
//        Si está bloqueado, el hilo actual se suspende
        synchronized(contador)
        {
            for (int j=0;j<300;j++)
            {
                contador.incrementa();
                try
                {
                    sleep(10);
                }
                catch(InterruptedException e){}
            }
            System.out.println(getName() + " contador vale " +  contador.getValor());
        }
    }
}