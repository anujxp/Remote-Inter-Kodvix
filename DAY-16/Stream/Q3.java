import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        class Developer {
            String name;
            List<String> skills;

            Developer(String name, List<String> skills) {
                this.name = name;
                this.skills = skills;
            }

            public List<String> getSkills() {
                return skills;
            }
        }

        List<Developer> team = Arrays.asList(
                new Developer("Alice", Arrays.asList("Java", "Spring", "Docker")),
                new Developer("Bob", Arrays.asList("Python", "Java", "Kubernetes")),
                new Developer("Charlie", Arrays.asList("Spring", "AWS"))
        );

        List<String> list = team.stream().flatMap(developer -> developer.getSkills().stream()).distinct().sorted().toList();
        System.out.println(list);


    }
}
