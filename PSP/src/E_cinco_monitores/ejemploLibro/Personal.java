/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.ejemploLibro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josti
 */
public class Personal extends Thread
{
        String nom;
        Saludo  salu;
        boolean esJ;
        
        public Personal (String nombre, Saludo saludo, boolean esJefe)
        {
            this.nom = nombre;
            this.salu = saludo;
            this.esJ = esJefe; 
        }
        public void run()
        {
            System.out.println(nom + " acaba de llegar.");
            try
            {
                Thread.sleep(100);
                if(esJ)
                {
                    salu.saludoJefe(nom);
                }
                else{
                    salu.saludoEmpleado(nom);
                }
            }
            catch(InterruptedException ex)
            {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
