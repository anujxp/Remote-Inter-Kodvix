import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.0, "Electronics"),
                new Product("Smartphone", 800.0, "Electronics"),
                new Product("Headphones", 150.0, "Electronics"),
                new Product("Monitor", 300.0, "Electronics"),
                new Product("Keyboard", 50.0, "Electronics"),
                new Product("Table", 200.0, "Furniture")
        );

        List<Comparator<Product>> list = products.stream().filter(s -> "Electronics".equalsIgnoreCase(s.getCategory())).map(product -> Comparator.comparingDouble(Product::getPrice).reversed()).limit(3).toList();
        System.out.println(list);
        Map<String, List<Double>> priceMap = list.stream() // This must be a Stream<Product>
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getPrice, Collectors.toList())
                ));
        System.out.println(priceMap);
    }
}
class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
