package org.designpattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Singelton singleton = Singelton.getSingelton();
        System.out.println(singleton.print());
        System.out.println(singleton);

        Constructor<Singelton> constructor = Singelton.class.getDeclaredConstructor();
        constructor.setAccessible(true); // Forces the private constructor to be public
        Singelton instance2 = constructor.newInstance();
        System.out.println(instance2);
    }
}
