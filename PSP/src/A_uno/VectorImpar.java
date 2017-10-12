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
public class VectorImpar extends Thread
{
    int start, finish;
    public VectorImpar(int start, int finish)
    {
        this.start=start;
        this.finish=finish;
    }

    public static void main(String[] args) 
    {   
        Runtime runtime=Runtime.getRuntime();
        int numHilos=runtime.availableProcessors();
//        System.out.println(numHilos);
        int tamano=31;
        VectorImpar[] hilos=new VectorImpar [tamano]; 
        int rango = tamano/numHilos; //definido tamaño=10, rango=2,5
//        System.out.println(rango);
        int start=0;
        int finish=rango; //finish=2, porque la variable es un entero
//        System.out.println(finish);
        for (int i = 0; i < numHilos; i++) 
        {
            if(i!=numHilos-1)
            {
                hilos[i]=new VectorImpar(start, finish);
                System.out.println("iteracion: " + i + " valores: " + start + " " + finish);
                hilos[i].start();
                start=finish;
                finish=finish+rango;
            }
            else
            {
                hilos[i]=new VectorImpar(start, tamano);
                System.out.println("iteracion: " + i + " valores: " + start + " " + tamano);
                hilos[i].start();
            }
        }
    }
}