package org.designpattern;

public class TestBuilder {
    public static void main(String[] args) {
        // Creating a high-end gaming laptop
        Laptop gamingLaptop = new Laptop.LaptopBuilder("Intel i9")
                .setRam(32)
                .setSsd(1024)
                .setGraphicsEnabled(true)
                .setDisplayType("OLED")
                .build();

        // Creating a basic office laptop (only mandatory + one optional)
        Laptop officeLaptop = new Laptop.LaptopBuilder("Intel i3")
                .setRam(8)
                .build();

        System.out.println(gamingLaptop);
        System.out.println(officeLaptop);
    }
}