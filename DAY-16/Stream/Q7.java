import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args) {
        List<String> codes = Arrays.asList("a15", "b2", "a10", "c5", "b2", "a20");
        List<Integer> a = codes.stream().filter(s -> s.startsWith("a")).map(s -> s.substring(1)).map(Integer::valueOf).toList();
        System.out.println(a);
        List<String> list = codes.stream().distinct().sorted().toList();
        System.out.println(list);
        codes.stream().sorted().peek(System.out::print).skip(2).limit(2).forEach(String::toUpperCase);
        String collect = codes.stream().filter(s -> s.startsWith("a")).sorted().collect(Collectors.joining(" "));
        System.out.println("\n"+collect);
    }
}
