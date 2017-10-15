/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio3;

/**
 *
 * @author usuario1
 */
public class Documento {
    private int escritores = 0;
    private int lectores = 0;
    boolean escribiendo = false;

//    public Documento() {
//    }

    public synchronized void entrar_lector() 
    {
        while ( escribiendo) 
        {
            try { 
                System.out.println("Lector esperando");
                wait();
            } catch (InterruptedException e) {}
        }
        lectores++;
    }

    public synchronized void salir_lector() 
    {
        System.out.println("Lector termina");
        lectores--;
        notifyAll();
    }

    public synchronized void entrar_escritor() 
    {    
        while (lectores > 0 || escribiendo) //si hay lectores o se está escribiendo
        {
            try {
                System.out.println("Escritor esperando");
                wait();
            } catch (InterruptedException e) {
            }
        }
        escribiendo = true;
    }

    public synchronized void salir_escritor() 
    {
        System.out.println("Escritor termina");
        escribiendo = false;
        notifyAll();
    }
}