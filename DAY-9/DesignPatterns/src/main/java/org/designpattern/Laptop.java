package org.designpattern;

public class Laptop {
    // 1. All attributes are final for immutability
    private final String processor;
    private final int ram;
    private final int ssd;
    private final boolean isGraphicsEnabled;
    private final String displayType;

    // 2. Private constructor: Only the Builder can create a Laptop
    private Laptop(LaptopBuilder builder) {
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.ssd = builder.ssd;
        this.isGraphicsEnabled = builder.isGraphicsEnabled;
        this.displayType = builder.displayType;
    }

    @Override
    public String toString() {
        return "Laptop [Processor=" + processor + ", RAM=" + ram + "GB, SSD=" + ssd +
                "GB, Graphics=" + isGraphicsEnabled + ", Display=" + displayType + "]";
    }

    // 3. Static Inner Builder Class
    public static class LaptopBuilder{
        private String processor; // Mandatory
        private int ram;          // Optional
        private int ssd;          // Optional
        private boolean isGraphicsEnabled;
        private String displayType;

        // Builder Constructor for Mandatory fields
        public LaptopBuilder(String processor) {
            this.processor = processor;
        }

        // Setter-like methods that return "this" (Method Chaining)
        public LaptopBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public LaptopBuilder setSsd(int ssd) {
            this.ssd = ssd;
            return this;
        }

        public LaptopBuilder setGraphicsEnabled(boolean isGraphicsEnabled) {
            this.isGraphicsEnabled = isGraphicsEnabled;
            return this;
        }

        public LaptopBuilder setDisplayType(String displayType) {
            this.displayType = displayType;
            return this;
        }

        // 4. The build() method to return the final object
        public Laptop build() {
            return new Laptop(this);
        }
    }
}