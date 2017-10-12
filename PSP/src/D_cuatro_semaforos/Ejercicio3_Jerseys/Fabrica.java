/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio3_Jerseys;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author josti
 */
public class Fabrica {
    static volatile boolean fin; //para que el compilador asuma que el valor de la variable puede cambiar en cualquier momento
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int CAPACIDADMANGAS=20;
        final int CAPACIDADCUERPOS=8;
        Scanner entradaEscanner= new Scanner(System.in);
        
        Semaphore cestaCapacidadCuerpos= new Semaphore(CAPACIDADCUERPOS);
        Semaphore cestaCantidadCuerpos= new Semaphore(0);
        Semaphore cestaCapacidadMangas= new Semaphore(CAPACIDADMANGAS);
        Semaphore cestaCantidadMangas= new Semaphore(0);
        
        FabricaCuerpos op1=new FabricaCuerpos(cestaCantidadCuerpos,cestaCapacidadCuerpos);
        FabricaMangas op2=new FabricaMangas(cestaCantidadMangas,cestaCapacidadMangas);
        MontaJersey m1=new MontaJersey(cestaCantidadCuerpos,cestaCapacidadCuerpos,cestaCantidadMangas,cestaCapacidadMangas);
        fin=false;
        op1.start();
        op2.start();
        m1.start(); 
        entradaEscanner.nextLine();
        op1.parar();
        op2.parar();
        m1.parar();
    }   
}