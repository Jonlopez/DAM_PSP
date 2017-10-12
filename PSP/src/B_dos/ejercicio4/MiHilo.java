/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio4;

/**
 *
 * @author usuario1
 */
public class MiHilo implements Runnable{
   
	
	public MiHilo (){
		
	}
    
    public void run () {
        System.out.println("La priridad con la que se lanza hilo1 es: "+Thread.currentThread().getPriority());
        
        for (int i=0;i<100;i++)
            if((i % 2)==0){
            System.out.println (i);
            }
      // System.out.print(Thread.currentThread().getPriority());
    }
}
