/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.Ejercicio2;

import java.util.Scanner;

/**
 *
 * @author usuario1
 */
public class Ejer2 {
    

    static final int NUMCONSUM = 10;
	/**
	 * @param args
	 */
    public static void main(String[] args) 
    {
        Buffer buffer = new Buffer();

        Productor productor = new Productor(buffer);
        Consumidor consumidores [] = new Consumidor[NUMCONSUM];
        for (int i = 0; i<NUMCONSUM; i++)
        {
            consumidores [i] = new Consumidor(i,buffer);
        }
        Scanner teclado = new Scanner (System.in);

        productor.start();
        for (int i = 0; i< NUMCONSUM; i++)
        {
                consumidores[i].start();
        }
        teclado.nextLine();
        productor.finalizar();
        for (int i = 0; i< NUMCONSUM; i++)
        {
                consumidores[i].finalizar();
        }
    }
}