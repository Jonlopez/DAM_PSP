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
public class SincroEjer3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //AQUI PODEMOS CAMBIAR LA CANTIDAD DE DINERO DE LA QUE DISPONEMOS
        Cuenta c = new Cuenta(20);
        SacarDinero h1 = new SacarDinero("Andere",c);
        SacarDinero h2 = new SacarDinero("Joana",c);
        h1.start();
        h2.start();
    }
}