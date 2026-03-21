package org.example;

class MyThread extends Thread
{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run(){
        int i =0;
        while(i<5){
            System.out.println(Thread.currentThread().getName());
            i++;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Inturrupt {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("first");
        t1.start();
        t1.interrupt();
        Thread.yield();
        t1.setDaemon(true);

    }
}
