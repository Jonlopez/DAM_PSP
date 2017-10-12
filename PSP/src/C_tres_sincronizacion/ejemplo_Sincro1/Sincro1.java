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
public class Sincro1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contador cont = new Contador(100);
        HiloA a = new HiloA("HiloA",cont);
        HiloB b = new HiloB("HiloB",cont);
        a.start();
        b.start();
    }   
}