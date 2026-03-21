package org.example;

public class CheckSynchronization {
    public static void main(String[] args) {
        Counter count  = new Counter();
        MyThread1 t1 = new MyThread1(count);
        MyThread1 t2 = new MyThread1(count);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Exception occur " + e.getMessage());;
        }
        System.out.println(count.getCount());

    }

}
