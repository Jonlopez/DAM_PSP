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
public class Saludo {
        public Saludo()
        {
        }
            public synchronized void saludoEmpleado(String nombre)
            {
                try{
                    wait();
                    System.out.println(nombre+ ": Buenos dias jefe.");
                }
                catch(InterruptedException ex){
                    Logger.getLogger(Saludo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            public synchronized void saludoJefe(String nombre)
            {
                System.out.println("*******" + nombre + ": Buenos días empleados!*******");
                notifyAll();
            }
}
