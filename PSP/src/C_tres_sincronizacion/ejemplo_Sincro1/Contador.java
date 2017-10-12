/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.ejemplo_Sincro1;

/**
 *
 * @author josti
 */

public class Contador
{
    private int c=0;
    Contador(int c)
    {
        this.c=c;
    }
    public void incrementa()
    {
        c++;
    }
    public void decrementa()
    {
        c--;
    }
    public int getValor()
    {
        return c;
    }
}