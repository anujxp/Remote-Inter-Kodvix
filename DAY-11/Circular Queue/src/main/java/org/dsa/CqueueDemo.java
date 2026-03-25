package org.dsa;

public class CqueueDemo {
    public static void main(String[] args) {
        CirculerQueue cqueue = new CirculerQueue(5);
        for (int i = 0; i < 5; i++) {
            cqueue.insert(i+1);
        }

        cqueue.display();
        cqueue.insert(5+1);
        cqueue.display();
        cqueue.delete();
        cqueue.display();
        cqueue.insert(5+1);
        cqueue.peek();
        cqueue.display();



        CQueueChar c = new CQueueChar(5);
        char a ='a';
        c.insert(a++);
        c.display();
        c.insert(a++);
        c.display();
        c.insert(a++);
        c.display();
        c.insert(a++);
        c.display();
        c.insert(a++);
        c.display();
        c.insert(a++);
        c.delete();
        c.insert(a++);
        c.display();



    }
}
