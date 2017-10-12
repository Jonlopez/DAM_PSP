/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_uno;

/**
 *
 * @author josti
 */
public class Hilo extends Thread {

    private static int cont=0;
    
    public static void main(String[] args) {
        Hilo[] vec=new Hilo[80000];
        for (int i = 0; i < vec.length; i++) 
        {
            vec[i]=new Hilo();
            vec[i].start();
        }
        try
        {
            for (int i = 0; i < vec.length; i++) 
            {
                vec[i].join();
            }
        }catch(Exception e){}
        System.out.println(cont);
    }
    public void run()
    {
        for (int i = 0; i < 1000; i++) 
        {
            cont++;
        }
    }
}