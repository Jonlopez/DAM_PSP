/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.Sincro_ejercicio1;

/**
 *
 * @author josti
 */
public class Aumentar extends Thread
{
    int n;
    Variable var=new Variable();

    public Aumentar(int n) {
        this.n = n;
    }
    public void run() 
    {
        var.suma(n);
    }
}