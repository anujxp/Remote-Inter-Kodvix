package org.example;

public class ManualThreads {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread(()-> {
                System.out.println("factorial of "+ finalI + ":"+ calculateFactorial(finalI));
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Total Time: " + (System.currentTimeMillis() - startTime) + "ms");
    }



    public static void ars(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];

        for (int i = 1; i <= 9; i++) {
            int finalI = i;
            threads[i - 1] = new Thread(() -> {
                long result = calculateFactorial(finalI);
                System.out.println("Factorial of " + finalI + " is: " + result);
            });
            threads[i - 1].start();
        }

        // We must manually join every thread to wait for them to finish
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Total Time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    private static long calculateFactorial(int n) {
        try { Thread.sleep(1000); } catch (InterruptedException e) {} // Simulating heavy work
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }
}