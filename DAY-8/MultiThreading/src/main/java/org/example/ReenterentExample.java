package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterentExample {
    private final Lock lock = new ReentrantLock();
    public void outer(){
        lock.lock();
        try {
            System.out.println("outer method");
            inner();
        }finally {
            lock.unlock();
        }
    }
    public  void inner(){
        lock.lock();
        try{
            System.out.println("innermethod ");

        }finally {
            lock.unlock();
//            lock.unlock(); couse an exception IllegalMonitorStateException

        }
    }
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
ReenterentExample r = new ReenterentExample();
r.outer();
    }

}
