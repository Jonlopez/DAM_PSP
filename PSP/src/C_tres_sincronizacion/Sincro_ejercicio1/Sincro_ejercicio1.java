/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.Sincro_ejercicio1;

import javax.swing.JOptionPane;

/**
 *
 * @author josti
 */
public class Sincro_ejercicio1 {

    public static void main(String[] args) {
       // cuantas veces queremos incrementar
        int numh = Integer.parseInt(JOptionPane.showInputDialog("Cuantos hilos de incremento?"));
       // Cuanto queremos incrementar cada vez
        int incre = Integer.parseInt(JOptionPane.showInputDialog("Cuanto incremento?"));
         
        Aumentar arraya[]=new Aumentar[numh];
        for(int i=0;i<numh;i++)
        {
            arraya[i]= new Aumentar(incre);
        }
        for(int i=0;i<numh;i++)            
        {
            arraya[i].start();
        }
    }        
}