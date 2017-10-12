/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio6;

/**
 *
 * @author jfaces
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Numeros hilo = new Numeros();
        Numeros hilo2 = new Numeros();
        Thread h1=new Thread(hilo);
        Thread h2=new Thread(hilo2);
        System.out.println("empieza el programa");
        h1.start();
        h2.start();
    }  
}

class Numeros implements Runnable
{
    public void run(){
        for (int i = 1; i < 16; i++) {
            System.out.println("Hilo: "+ Thread.currentThread().getName() + " vuelta: " + i);
        }
        System.out.println("fin del programa");
    }
}