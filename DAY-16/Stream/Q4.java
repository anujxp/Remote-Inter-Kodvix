import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Q4 {
    public static void main(String[] args) {
        List<Account> accounts = Arrays.asList(
                new Account("A1", Arrays.asList(100.0, -5.0, 20.0)),
                new Account("B2", Arrays.asList(500.0, -10.0)),
                new Account("C3", Arrays.asList(50.0, 650.0, -100.0))
        );
        Double max = accounts.stream().flatMap(acc -> acc.getTransactions().stream()).filter(x -> x > 0).max(Double::compare).orElse(0.0);
        System.out.println(max);
    }
}

class Account {
    private String accountNumber;
    private List<Double> transactions;

    public Account(String accountNumber, List<Double> transactions) {
        this.accountNumber = accountNumber;
        this.transactions = transactions;
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
