/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio7;

public class Ejer27 extends Thread
{
    private static int cont;

    @Override
    public void run() 
    {
        for (int i = 0; i < 5; i++) {
            cont++; //cont=cont +1;
            System.out.println("El hilo: " + this.getName() + " ha imprimido " + cont);        
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Ejer27[] vec= new Ejer27[4];
        for (int i = 0; i < vec.length; i++) {
           vec[i]=new Ejer27();
           vec[i].start();     
        }
        //EL VALOR DE CONTADOR SERA SIEMPRE EL MISMO???
        System.out.println("el valor de contador es "+cont);
    }
}
