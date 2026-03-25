package org.dsa;

public class ReverseQueue {
    public static void main(String[] args) {
        CirculerQueue cqueue = new CirculerQueue(5);
        Stack stack = new Stack(5);
        for (int i = 0; i < 5; i++) {
            cqueue.insert(i+1);
        }
        cqueue.display();
        for (int i = 0; i < 5; i++) {
            stack.push(cqueue.delete());
        }
        System.out.println();
        cqueue.display();
        for (int i = 0; i < 5; i++) {
            cqueue.insert(stack.pop());
        }
        cqueue.display();


    }
}
