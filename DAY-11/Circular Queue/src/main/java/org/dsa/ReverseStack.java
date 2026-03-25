package org.dsa;

public class ReverseStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        CirculerQueue queue = new CirculerQueue(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i+1);
        }
        stack.display();
        for (int i = 0; i < 5; i++) {
            queue.insert(stack.pop());
        }
        System.out.println("stack ");
        stack.display();
        for (int i = 0; i < 5; i++) {
            stack.push(queue.delete());
        }
        System.out.println("stack");
        stack.display();
    }

}
