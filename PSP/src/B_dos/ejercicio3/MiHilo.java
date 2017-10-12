/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio3;

/**
 *
 * @author usuario1
 */
public class MiHilo extends Thread{

    public MiHilo() {
    }
    
    public void run(){
        for(int i=1;i<6;i++){
            System.out.println("Hilo de nombre "+this.getName()+" contador "+i);
//            Thread.currentThread().getName();
        }
    }
}