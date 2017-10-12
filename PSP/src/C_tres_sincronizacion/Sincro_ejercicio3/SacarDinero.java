/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.Sincro_ejercicio3;
/**
 *
 * @author josti
 */
public class SacarDinero extends Thread
{
    private Cuenta c;
    String nombre;
    
    public SacarDinero(String nom, Cuenta cuen)
    {
        this.nombre=nom;
        this.c=cuen;
    }
    public void run()
    {
        for(int x=1;x<=4;x++)
        {
            c.retirarDinero(10, nombre);
        }
    }
}