package org.dsa;

import java.util.Scanner;

class CharQueue01 {
    char queue[];
    int f = -1;
    int r = -1;
    int size;

    CharQueue01(int size) {
        this.size = size;
        queue = new char[size];
    }

    void insert(char ch) {
        if (r == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        if (f == -1) {
            f = 0;
        }
        queue[++r] = ch;
    }

    void delete() {
        if (f == -1 || f > r) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Deleted: " + queue[f]);
        f++;
    }

    void display() {
        if (f == -1 || f > r) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = f; i <= r; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }

    void countVowels() {
        int count = 0;
        for (int i = f; i <= r; i++) {
            if (isVowel(queue[i])) count++;
        }
        System.out.println("Vowels: " + count);
    }

    void countConsonants() {
        int count = 0;
        for (int i = f; i <= r; i++) {
            if (Character.isLetter(queue[i]) && !isVowel(queue[i]))
                count++;
        }
        System.out.println("Consonants: " + count);
    }

    void search(char key) {
        for (int i = f; i <= r; i++) {
            if (queue[i] == key) {
                System.out.println("Character found");
                return;
            }
        }
        System.out.println("Character NOT found");
    }
}

class CharQueueDemo01{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        CharQueue01 q = new CharQueue01(5);
        int choice;
        char ch;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Count Vowels");
            System.out.println("5. Count Consonants");
            System.out.println("6. Search Character");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter character: ");
                    ch = sc.next().charAt(0);
                    q.insert(ch);
                    break;

                case 2:
                    q.delete();
                    break;

                case 3:
                    q.display();
                    break;

                case 4:
                    q.countVowels();
                    break;

                case 5:
                    q.countConsonants();
                    break;

                case 6:
                    System.out.print("Enter character to search: ");
                    ch = sc.next().charAt(0);
                    q.search(ch);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 7);
    }
}