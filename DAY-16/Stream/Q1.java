import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Q1{
    public static void main(String args[]){

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig");
        List<String> g5 = new ArrayList<>();
        for (String string : fruits) {
            if(string.length()>5)
                g5.add(string);
        }
        for (String s : g5) {
            System.out.println(s);
        }

        fruits.stream().filter(s->s.length()>5).forEach(System.out::println);
        List<String> list = fruits.stream().filter(s -> s.length() > 5).map(String::toUpperCase).toList();
        list.forEach(System.out::println);
        // List<String> words = Arrays.asList("  java  ", "  stream  ", "  api  ");
        // words.stream().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        // List<String> names = Arrays.asList("Amy", "Bob", "Charlie", "David", "Edward", "Frank", "Gigi");
        // Map<Integer, List<String>> collect = names.stream().collect(Collectors.groupingBy(String::length));
        // System.out.println(collect);

    }
}