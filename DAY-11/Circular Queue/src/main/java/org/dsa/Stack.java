package org.dsa;

public class Stack {
    private int[]stack;
    private int top;
    private int size;
    public  Stack(int size){
        stack = new int[size];
        this.size = size;
        top = -1;
    }

    public void push(int data) {
        if(top == size-1) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = data;
    }

    public int pop(){
        if(top==-1){
            System.out.println("Stack UnderFlow");
            return 0;
        }
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public void display(){
        if(top == -1){
            System.out.println("Stack UnderFlow");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
