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
public class Variable 
{
    static  int total=0;
    public static synchronized void suma(int num)
    {  
        total=total+num;
        System.out.println("Despues de sumar " + total);
    }
    public static synchronized void resta(int num)
    { 
        total=total-num;
        System.out.println("Despues de restar  "+ total);
    }
    public void saludo(){
        System.out.println("Metodo no sincronizado de la clase");
    }
}
