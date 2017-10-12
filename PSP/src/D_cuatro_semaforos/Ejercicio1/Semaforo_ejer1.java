/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_cuatro_semaforos.Ejercicio1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author josti
 */
public class Semaforo_ejer1 
{
    public static void main(String args[]) {
        Semaphore s = new Semaphore(10);//un semaforo de 10 recursos
        
        //acquire(10) = esperará a tener los 10 recursos disponibles 
        //y hasta que no tenga los 10 disponibles no hará nada.
        //acquire() = intentará tener un recurso disponible de los diez
        
        //EL ORDEN DE LANZAMIENTO DA IGUAL, PODEMOS DEFINIR LOS 10 LECTORES A LA VEZ
        for (int i = 1; i <= 5; i++) {
            new Lector("Lector" + i, s).start();
        }
        for (int i = 1; i < 4; i++) {
            new Escritor("Escritor" + i, s).start();
        }
        for (int i = 6; i <= 10; i++) {
            new Lector("Lector" + i, s).start();
        }
    }
}