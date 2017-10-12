/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio2;

import D_cuatro_semaforos.Ejercicio2.Profe;
import D_cuatro_semaforos.Ejercicio2.Caja;
import java.util.concurrent.Semaphore;

/**
 *
 * @author josti
 */
public class Semaforo_ejer2_juguetes {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Caja total=new Caja(3);
        Semaphore mutex = new Semaphore(1);
        Alumno n1 = new Alumno(mutex,total);
        Alumno n2 = new Alumno(mutex,total);
        Alumno n3 = new Alumno(mutex,total);
        Alumno n4 = new Alumno(mutex,total);
        Profe m1 = new Profe(mutex,total);
        //--EJECUTAR 4 NIÑOS
        n1.start();
        n2.start();
        n3.start();
        n4.start();
        //--EJECUTAR LA PROFE
        m1.start();
    }
}
