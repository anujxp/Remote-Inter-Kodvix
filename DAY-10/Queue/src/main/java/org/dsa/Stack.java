package org.dsa;

import java.util.Scanner;

class Stack{
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
    public void sumOfEven(){
        if(top==-1){
            System.out.println("Stack UnderFlow");
            return;
        }
        int sum = 0;
        for (int i = top; i >= 0 ; i--) {
            if(stack[i]%2 == 0){
                sum+=stack[i];
            }
        }
        System.out.println(sum);
    }

    public void sumOfOdd() {
        if(top==-1){
            System.out.println("Stack UnderFlow");
            return;
        }
        int sum = 0;
        for (int i = top; i >= 0 ; i--)
            if(stack[i]%2!=0)
                sum+=stack[i];
        System.out.println(sum);
    }

    public void count() {
        int oddCount = 0;
        int evenCount = 0;
        for (int i = top; i >=0; i--) {
            if(stack[i]%2 == 0)
                evenCount++;
            else oddCount++;
        }
        System.out.println("Even count " + evenCount );
        System.out.println("Odd Count " + oddCount);
    }
}


class StackDemo {
    public static void main(String[] args){
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the stack");
        int size = sc.nextInt();
        Stack stack = new Stack(size);
        do{
            System.out.println("-------------------------------------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4.peek");
            System.out.println("5. Sum of Even");
            System.out.println("6. Sum of Odd");
            System.out.println("7. count odd And Even");
            System.out.println("8. Exit");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the data");
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println("The Poped Item is "+ stack.pop());
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println(stack.peek());
                    break;
                case 5:
                    stack.sumOfEven();
                    break;
                case 6 :
                    stack.sumOfOdd();
                    break;
                case 7 :
                    stack.count();
                    break;
                case 8 :
                    System.exit(0);
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }while(choice!=8);
//        Stack nums = new Stack(5);
//        nums.push(1);
//        nums.push(2);
//        nums.push(3);
//        System.out.println(nums.peek());
//        nums.pop();
//        System.out.println(nums.peek());
//        nums.display();
        //        System.out.println(nums.sear
    }
}