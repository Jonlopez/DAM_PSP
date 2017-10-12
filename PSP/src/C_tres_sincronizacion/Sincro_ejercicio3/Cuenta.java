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
public class Cuenta
{
    private int saldo;
    Cuenta(int sal)
    {
        saldo=sal;
    }
    int getSaldo()
    {
        return saldo;
    }
    void restar(int cantidad)
    {
        saldo=saldo-cantidad;
    }
    synchronized void retirarDinero(int cant, String nom)
    {
        if(getSaldo()>=cant)
        {
            System.out.println("Se va a retirar la cantidad de " + cant + " . Saldo actual: " + getSaldo());
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e){}
            restar(cant);
            System.out.println(nom + " retira => " + cant + " .Saldo disponible actualizado: " + getSaldo());
        }else{
            System.out.println("No dispone de la cantidad " + cant + ". Su saldo es de: " + getSaldo());
        }
        if(getSaldo()<0)
        {
            System.out.println("Su saldo es negativo: " + getSaldo());
        }
    }
}