package org.designpattern;

public class Singelton {
    private static Singelton singelton;
    private Singelton(){
        if(singelton!= null)
            throw new RuntimeException("object already created");
    }
    public static Singelton getSingelton(){

        if (singelton == null){
            synchronized (Singelton.class) {
                singelton = new Singelton();
            }
        }
        return singelton;
    }
    public int print(){
       return 8;
    }
}
