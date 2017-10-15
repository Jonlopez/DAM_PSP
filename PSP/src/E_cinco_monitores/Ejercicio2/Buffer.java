/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio2;

/**
 *
 * @author usuario1
 */
public class Buffer
{
    private int valor;
    private boolean nuevo,leido;
    private boolean fin;

    public Buffer ()
    {
            nuevo = false;
            leido = true;
            fin = false;
    }
    public synchronized int getValor(int id) 
    {
        int value=0;
        while ((!nuevo)&&(!fin))
        {
            try 
            {
                System.out.println("Bloqueo el consumidor");
                wait();
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        if (!fin)
        {
            value =  valor;
            System.out.println ("\tConsumidor "+id+": "+value);
            nuevo = false;
            leido = true;
            notifyAll();
        }
        return value;
    }

    public synchronized void setValor(int valor) 
    {
        while ((!leido)&&(!fin))
        {
            try 
            {
                System.out.println("Bloqueo el productor");
                wait();
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        if (!fin)
        {
            System.out.println("Productor: "+valor); 
            this.valor = valor;
            leido= false;
            nuevo = true;
            notifyAll();
        }
    }
    public synchronized void cerrar()
    {
        fin = true;
        notifyAll();
    }
}