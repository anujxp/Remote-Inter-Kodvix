import java.util.Arrays;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 25, true),
                new User("Bob", 17, false),
                new User("Charlie", 15, true),
                new User("David", 30, false),
                new User("Eve", 12, false)
        );

        boolean hasRisk = users.stream().anyMatch(u -> u.getAge() < 18 && u.isEmailVerified());
        System.out.println(hasRisk);
        String riskUser = users.stream().filter(u -> u.getAge() < 18).findFirst().map(User::getName).orElse("Allclear");
        System.out.println(riskUser);
        boolean b = users.stream().allMatch(u -> u.getAge() > 10);
        System.out.println(b);
    }




}

class User {
    private String name;
    private int age;
    private boolean isEmailVerified;

    public User(String name, int age, boolean isEmailVerified) {
        this.name = name;
        this.age = age;
        this.isEmailVerified = isEmailVerified;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isEmailVerified() { return isEmailVerified; }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", verified=" + isEmailVerified + "}";
    }
}