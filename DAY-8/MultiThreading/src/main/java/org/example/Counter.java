package org.example;

public class Counter {
    private volatile int count;
    public Counter(){
        this.count=0;
    }
    public   void  increment(){
//        synchronized(this)
//        {
            this.count++;
//        }
    }


    public int getCount() {
        return count;
    }
}
