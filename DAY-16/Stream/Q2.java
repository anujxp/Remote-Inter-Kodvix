import java.util.Arrays;
import java.util.List;

class Order {
    String id;
    double amount;
    String status; // "PENDING", "SHIPPED", "DELIVERED"

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    Order(String id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }
    // Assume getters exist: getId(), getAmount(), getStatus()
}



public class Q2 {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("1", 100.0, "SHIPPED"),
                new Order("2", 50.0, "PENDING"),
                new Order("3", 250.0, "SHIPPED"),
                new Order("4", 400.0, "DELIVERED")
        );
        double shipped = orders.stream().filter(order -> "SHIPPED".equalsIgnoreCase(order.getStatus())).mapToDouble(Order::getAmount).sum();
        System.out.println(shipped);


        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Cherry", "Date"),
                Arrays.asList("Elderberry", "Fig")
        );
        List<String> list = nestedList.stream().flatMap(List::stream).filter(s -> s.toLowerCase().contains("a")).toList();
        System.out.println(list);
        
    }

}
