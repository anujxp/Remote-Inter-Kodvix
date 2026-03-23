package org.designpattern;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending an email notification...");
    }

}

class SmsNotification implements Notification{

    @Override
    public void notifyUser() {
        System.out.println("Sending An Sms Notification.....");
    }
}