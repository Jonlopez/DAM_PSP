/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio3;

/**
 *
 * @author usuario1
 */
public class Escritor extends Thread
{ 
    Documento documento;

    public Escritor(Documento documento) 
    {
        this.documento = documento;
    }

    private void escribiendo() 
    {
        System.out.println("Escribiendo");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Fin de escritura");
    }

    public void run() 
    {
        documento.entrar_escritor();
        escribiendo();
        documento.salir_escritor();
    }
}