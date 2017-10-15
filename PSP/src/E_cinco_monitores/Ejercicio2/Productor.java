/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio2;

import java.util.Random;

/**
 *
 * @author usuario1
 */
public class Productor  extends Thread 
{
	Random random = new Random();
	Buffer buffer;
	boolean fin;
	int valor;
	
	public Productor (Buffer buffer)
        {
            this.buffer = buffer;
            fin = false;
	}
	public void run()
        {
            while (!fin)
            {
                valor = random.nextInt(100);
                buffer.setValor(valor);
            }
	}
	public void finalizar()
        {
		fin = true;
		buffer.cerrar();
	}
}