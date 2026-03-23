package org.designpattern;

public class NotificationFactory
{
    public static Notification createNotification(String channel){
        if(channel== null || channel.isEmpty())
            return null;
        switch (channel.toUpperCase()){
            case "EMAIL": return new EmailNotification();
            case "SMS": return  new SmsNotification();
            default: throw new IllegalArgumentException("Uknown channel "+ channel);
        }
    }
}
