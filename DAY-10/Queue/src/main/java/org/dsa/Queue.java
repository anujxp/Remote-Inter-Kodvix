package org.dsa;

public class Queue {
    int queue[];
    int f;
    int r;
    int size;

    public Queue(int size) {
        this.size = size;
        this.queue = new int[size];
        f = -1;
        r = -1;
    }

    public Queue() {
    }

    void insert(int value) {
        if (r == size - 1) {
            System.out.println("Queue is full");
            System.exit(0);
        }
        if (f == -1) {
            f = 0;
        }
        queue[++r] = value;
    }

    int delete() {
        if (f == -1 || f == r+1) {
            System.out.println("Queue is empty");
            return 0;
        }

        int y = queue[f];
        f++;
        return y;
    }


    void display() {
        if ((f == -1) || (f == r + 1)) {
            System.out.println("Queue is Empty");
            return;
        }
        for (int i = f; i <= r; i++) {
            System.out.print(queue[i]);
        }
    }
    void peek(){

        if ((f == -1) || (f == r + 1)) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(queue[f]);

    }
}
