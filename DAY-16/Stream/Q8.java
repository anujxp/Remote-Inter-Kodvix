import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Q8 {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = nums.stream().reduce(0, Integer::sum);
        System.out.println(reduce.intValue());
        double average = nums.stream().mapToInt(x -> x).summaryStatistics().getAverage();
        System.out.println(average);
//         nums.stream().mapToInt(x -> x).summaryStatistics().;

    }
}
