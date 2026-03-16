package com.dsa.stack;

public class CopyStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        Stack tempStack = new Stack(stack.length());
        Stack stackCopy = new Stack(stack.length());


        while (stack.length() > 0) {
            tempStack.push(stack.pop());
        }

        while (tempStack.length() > 0) {
            stackCopy.push(tempStack.pop());
        }

        stackCopy.display();

    }


}

