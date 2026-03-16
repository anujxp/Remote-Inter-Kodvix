package com.dsa.stack;

class Stack {
    private int[] stack;
    private int top;
    private int size;

    public Stack(int size) {
        stack = new int[size];
        this.size = size;
        top = -1;
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = data;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack UnderFlow");
            return 0;
        }
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }
    public int length(){
        return top +1;
    }
    public void display() {
        if (top == -1) {
            System.out.println("Stack UnderFlow");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
public class ReverseStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        Stack stack1 = new Stack(stack.length());
        Stack stack2 = new Stack(stack.length());


        while (stack.length() > 0) {
            stack1.push(stack.pop());
        }

        while (stack1.length() > 0) {
            stack2.push(stack1.pop());
        }

        while (stack2.length() > 0) {
            stack.push(stack2.pop());
        }

        stack.display();

    }
}
