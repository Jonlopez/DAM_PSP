/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B_dos.ejercicio8;

import javax.swing.JOptionPane;

/**
 *
 * @author usuario1
 */
public class Ejer8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Cuantos terminos?"));
        GeneraEnteros serie =new GeneraEnteros(numero, "hilo 1",1000);
        serie.start();

        System.out.println("Termina Hilo principal en main()");
    }
}