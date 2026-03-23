package org.designpattern;

import java.util.Scanner;

public class TestFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter channel...");
        String s = sc.nextLine();
        Notification notification = NotificationFactory.createNotification(s);
        notification.notifyUser();
    }
}
