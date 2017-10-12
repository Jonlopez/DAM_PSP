/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.ejemploLibro;

/**
 *
 * @author josti
 */
public class Main {
    public static void main(String[] args)
        {
            Saludo s = new Saludo(); //Objeto en comun, se encarga del wait y notify
            
            //Paso por parametros el nombre del hilo, el objeto comun SALUDO y un booleano para saber si es jefe o no
            Personal p1 = new Personal("Jon",s,false);
            Personal p2 = new Personal("Ander",s,false);
            Personal p3 = new Personal("Miren",s,false);
            Personal j1 = new Personal("JEFE",s,true);
            p1.start();
            p2.start();
            p3.start();
            j1.start();
        }   
}