/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.Sincro_ejercicio2;

/**
 *
 * @author josti
 */
public class Decrementar extends Thread
{
    Variable variable=new Variable();
    int n;
    public Decrementar(int n) {
        this.n = n;
    }
     public void run()
    {
        variable.resta(n);//Llamamos a la operacion de restar, cuando un hilo la ejecuta ningun hilo
//        podra ejecutar ninguna otra operacion sincronizada
    }
}
