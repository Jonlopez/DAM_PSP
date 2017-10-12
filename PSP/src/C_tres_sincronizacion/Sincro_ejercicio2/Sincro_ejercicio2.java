/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.Sincro_ejercicio2;

import javax.swing.JOptionPane;

/**
 *
 * @author josti
 */
public class Sincro_ejercicio2 {

    public static void main(String[] args) {
        // TODO code application logic here
        
        int numh = Integer.parseInt(JOptionPane.showInputDialog("Cuantos hilos de incremento?"));
        int incre = Integer.parseInt(JOptionPane.showInputDialog("Cuanto incremento?"));
        int numh2 = Integer.parseInt(JOptionPane.showInputDialog("Cuantos hilos de decremento?"));
        int incre2 = Integer.parseInt(JOptionPane.showInputDialog("Cuanto decremento?"));
        
        Aumentar arraya[] = new Aumentar[numh];//Creamos un array de hilos que aumentan
        Decrementar arraya2[] = new Decrementar[numh2];//Creamos un array de hilos que decrementan
        for (int i = 0; i < numh; i++) 
        {
            arraya[i] = new Aumentar(incre);//Creamos cada uno de los hilos
        }
        for (int i = 0; i < numh2; i++) 
        {
            arraya2[i] = new Decrementar(incre2);//Creamos cada uno de los hilos
        }
        for (int i = 0; i < numh; i++) 
        {
            arraya[i].start(); //Lanzamos los hilos
        }
        for (int i = 0; i < numh2; i++) 
        {
            arraya2[i].start();//Lanzamos los hilos
        }
    }
}
