package org.dsa;

public class ReverseQueue {

    public static void main(String[] args) {
        Queue q = new Queue(5);
        Stack stack = new Stack(5);
        for(int i = 0;i<5;i++){
            q.insert(i);
        }
        q.display();
        System.out.println("-----");
        stack.display();
        for (int i = 0; i < 5; i++) {
            stack.push(q.delete());
        }
        System.out.println("-----");
        q.display();
        System.out.println("---------");
        stack.display();
        for (int i = 0; i < 5; i++) {
            q.insert(stack.pop());
        }
        System.out.println("-------");
        q.display();
        System.out.println("------");
        stack.display();

    }
}
