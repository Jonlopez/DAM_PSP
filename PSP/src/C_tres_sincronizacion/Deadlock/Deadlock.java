/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_tres_sincronizacion.Deadlock;

/**
 *
 * @author josti
 */

class A {
  synchronized void foo(B b) {
    String name = Thread.currentThread().getName();
    System.out.println(name + " entró en A.foo");
    try {
      Thread.sleep(1000);
    } catch(Exception e) {
      System.out.println("A Interrumpido");
    }
    System.out.println(name + " intentando llamar a B.last()");
    b.last(); //teniendo cogido el cerrojo de a, intenta coger el de b. Pero b esta esperando a que libere el cerrojo de a
  }
  synchronized void last() {
    System.out.println("Dentro de A.last");
  }
}
class B {
  synchronized void bar(A a) {
    String name = Thread.currentThread().getName();
    System.out.println(name + " entró en B.bar");
    try {
      Thread.sleep(1000);
    } catch(Exception e) {
      System.out.println("B Interrumpido");
    }
    System.out.println(name + " intentando llamar a A.last()");
    a.last();
  }
  synchronized void last() {
    System.out.println("Dentro de A.last");
  }
}
public class Deadlock implements Runnable {
  A a = new A();
  B b = new B();
  Deadlock() {
    Thread t = new Thread(this, "RacingThread");
    t.start();
    a.foo(b); //coge el cerrojo de a
    System.out.println("Regreso al hilo principal");
  }
  public void run() {
    b.bar(a); //coge el cerrojo de b
    System.out.println("Regreso al otro hilo");
  }
  public static void main(String args[]) {
    new Deadlock();
  }
}