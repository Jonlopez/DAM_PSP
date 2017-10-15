/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio3;

/**
 *
 * @author usuario1
 */
public class Lector extends Thread 
{
    Documento documento;

    public Lector(Documento documento) 
    {
        this.documento = documento;
    }

    private void leyendo() 
    {
        System.out.println("Leyendo");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public void run() 
    {
        documento.entrar_lector();
        leyendo();
        documento.salir_lector();
    }
}