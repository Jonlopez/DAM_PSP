/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_uno;

import java.util.Random;

public class Principal extends Thread{
        private static int tamano= 800;
	private static int[] vec = new int[tamano];//80.000.000
	private int inicio, fin;
	
	public Principal(int inicio, int fin){
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public static void main(String[] args){
		iniciavec();
		
		//opcion NO concurrente:
//		vec_NOconcurrente();
		
		//opcion concurrente:
		vec_concurrente();
	}
	
	//Metodo que inicia el vector estatico con valores aleatorios
	private static void iniciavec(){
		Random rand = new Random(System.nanoTime());
		
		for(int i = 0; i < vec.length; i++){
			vec[i] = rand.nextInt(10);
		}
	}
	
	//Metodo que NO utiliza el paralelismo y por tanto se ejecuta de forma secuencial
	private static void vec_NOconcurrente(){
		double tiempo = System.nanoTime();
		for(int i = 0; i < vec.length; i++){
			vec[i] /= 10;
			vec[i] *= 10;
			vec[i] /= 10;
		}
		System.out.println("Version NO concurrente: "+ ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");
	}
	
	//Metodo que ejecuta los hilos que que se lanzan
	public void run(){
		for(int i = inicio; i < fin; i++){
			vec[i] /= 10;
			vec[i] *= 10;
			vec[i] /= 10;
		}
	}
	
	//Metodo que ejecuta nproc hilos en paralelo y que llaman al metodo run para realizar la multiplicacion del
	//vector de forma paralela
	private static void vec_concurrente(){
		int nproc = Runtime.getRuntime().availableProcessors(); //Devuelve cuantos hilos puede ejecutar a la vez la CPU
		int inicio = 0, fin = 0;
		Principal[] prin = new Principal[nproc];
		
		double tiempo = System.nanoTime(); 	//Comienzo para capturar el tiempo que tarda en ejecutarse 
													
		for(int i = 0; i < nproc; i++){//Hará tantas iteraciones como nproc (hilos)
			inicio = fin;
			fin += vec.length/nproc; //si hay 4 hilos, fin=800/4 = 200
			prin[i] = new Principal(inicio, fin); //el primer hilo tendrá inicio 0, fin 200
                                                              //el segundo hilo tendrá inicio 200, fin 400
                                                              //el tercer hilo tendrá inicio 400, fin 600
                                                              //el cuarto hilo tendrá inicio 600, fin 800
			prin[i].start();
		}
		
		for(int i = 0; i < nproc; i++){
			try{
				prin[i].join();
			}catch(Exception e){}
		}
		System.out.println("Version Concurrente: "+ ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");
	}		
}