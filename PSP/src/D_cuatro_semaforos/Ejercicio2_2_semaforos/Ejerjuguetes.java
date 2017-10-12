/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio2_2_semaforos;

/**
 *
 * @author josti
 */
import java.util.concurrent.Semaphore;

public class Ejerjuguetes {
    public static void main(String[] args) 
    {
        Caja total=new Caja(3);
        Semaphore mutex = new Semaphore(1);
        Semaphore profe=new Semaphore(0); //para poder acceder a la seccion critica se debe ejecutar profe.release()
        Niño n1 = new Niño(profe,mutex,total);
        Niño n2 = new Niño(profe,mutex,total);
        Niño n3 = new Niño(profe,mutex,total);
        Niño n4 = new Niño(profe,mutex,total);
        Profe p1 = new Profe(profe,mutex,total);
        //--EJECUTAR NIÑOS
        n1.start();
        n2.start();
        n3.start();
        n4.start();
        //--EJECUTAR LA PROFE
        p1.start();
    }
}