public class LocalScopeExample {

    public static void main(String[] args) {

        int a = 10;

        if (true) {

            int b = 20;

            System.out.println(a); // valid
            System.out.println(b); // valid

        }

        System.out.println(a); // valid
        // System.out.println(b); // ERROR

    }
}