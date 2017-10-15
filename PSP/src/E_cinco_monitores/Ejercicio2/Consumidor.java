/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio2;

/**
 *
 * @author usuario1
 */
public class Consumidor extends Thread 
{
    int id;
    Buffer buffer;
    boolean fin;
    int valor;

    public Consumidor (int id, Buffer buffer)
    {
            this.buffer = buffer;
            fin = false;
            this.id = id;
    }

    public void run()
    {
        while (!fin)
        {
            valor = buffer.getValor(id);
        }			
    }
    public void finalizar()
    {
        fin = true;
        buffer.cerrar();
    }
}