/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E_cinco_monitores.ejemploSuspendResume;

/**
 *
 * @author josti
 */

class NewThread implements Runnable {
  String name; // nombre del hilo
  Thread t;
  boolean suspendFlag;
  
  NewThread(String threadname) {
    name = threadname;
    t = new Thread(this, name);
    System.out.println("Nuevo hilo: " + t);
    suspendFlag = false;
    t.start(); // Comienza el hilo
  }

  // Este es el punto de entrada del hilo.
  public void run() {
    try {
      for(int i = 15; i > 0; i--) {
        System.out.println(name + ": " + i);
        Thread.sleep(200);
        synchronized(this) {
          while(suspendFlag) {
            this.wait();
          }
        }
      }
    } catch (InterruptedException e) {
      System.out.println("Interrupción del hilo" + name);
    }
    System.out.println("Sale del hilo: " + name);
  }
  void mysuspend() {
    suspendFlag = true;
  }
  synchronized void myresume() {
    suspendFlag = false;
    notifyAll();
  }
}
public class SuspendResume {
  public static void main(String args[]) {
    NewThread ob1 = new NewThread("Uno");
    NewThread ob2 = new NewThread("Dos");
    try {
      Thread.sleep(1000);
      ob1.mysuspend();
      System.out.println("Suspende el hilo Uno");
      Thread.sleep(1000);
      System.out.println("Reanuda el hilo Uno");
      ob1.myresume();
      
      ob2.mysuspend();
      System.out.println("Suspende el hilo Dos");
      Thread.sleep(1000);
      System.out.println("Reanuda el hilo Dos");
      ob2.myresume();
      
    } catch (InterruptedException e) {
      System.out.println("Interrupción del hilo principal");
    }
    // espera hasta que terminen los otros hilos
    try {
      System.out.println("Espera finalización de los otros hilos.");
      ob1.t.join();
      ob2.t.join();
    } catch (InterruptedException e) {
      System.out.println("Interrupción del hilo principal");
    }
    System.out.println("Sale del hilo principal.");
  }
}