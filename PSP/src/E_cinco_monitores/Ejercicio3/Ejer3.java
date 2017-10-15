/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio3;

/**
 *
 * @author usuario1
 */
public class Ejer3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaramos un documento
        Documento d = new Documento();
//Iniciamos los hilos
        Lector l1 = new Lector(d);
        Lector l2 = new Lector(d);
        Lector l3 = new Lector(d);
        Lector l4 = new Lector(d);
        Lector l5 = new Lector(d);
        Lector l6 = new Lector(d);
        Escritor e1 = new Escritor(d);
        Escritor e2 = new Escritor(d);
//--EJECUTAR lectores
        e1.start();
        l1.start();
        l2.start();
        l3.start();

        l4.start();
        l5.start();
        l6.start();

//--EJECUTAR escritores

        e2.start();
    }
}