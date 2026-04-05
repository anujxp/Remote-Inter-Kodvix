import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(collect);
        List<String> items = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, List<String>> collect1 = items.stream().collect(Collectors.groupingBy(n -> n));
        System.out.println(collect1);
        Map<String, Long> counts = items.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), // The Key: the word itself
                        Collectors.counting() // The Downstream: count the occurrences
                ));
        System.out.println(counts);
    }
}
