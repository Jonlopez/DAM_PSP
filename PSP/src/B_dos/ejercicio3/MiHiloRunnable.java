/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio3;

/**
 *
 * @author eider
 */
public class MiHiloRunnable implements Runnable{
    

    @Override
    public void run(){
        for(int i=1;i<6;i++){
            System.out.println("Hilo de nombre "+Thread.currentThread().getName()+" contador "+i);
           
        //No podemos utilizar el this.getName(), porque la clase MiHiloRunnable no es un Thread.
        }
    }
}
