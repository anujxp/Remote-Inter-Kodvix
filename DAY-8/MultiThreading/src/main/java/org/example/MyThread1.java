package org.example;

public class MyThread1 extends Thread{
    private Counter count;
    public MyThread1(Counter count){
        this.count = count;
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            this.count.increment();
        }
    }
}
