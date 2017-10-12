/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_uno;

/**
 *
 * @author jfaces
 */
public class VectJoin extends Thread{
    
    private int id;
    
    public VectJoin(int id)
    {
        this.id=id;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VectJoin[] vec=new VectJoin[5];
        for (int i = 0; i < vec.length; i++) 
        {
            vec[i]= new VectJoin(i+1);
            vec[i].start();
            
        }

        try
        {
            for (int i = 0; i < vec.length; i++) {
                vec[i].join();
            }
            
        }catch(Exception e){}
        
        System.out.println();
    }
    
}
