import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String course = tokens[0];
            String student = tokens[1];

            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(student);

            input = scanner.nextLine();
        }

        courses
                .entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    int first = c1.getValue().size();
                    int second = c2.getValue().size();
                    return Integer.compare(second, first);
                })
                .forEach(c -> {
                    System.out.printf("%s: %d %n",
                            c.getKey(),
                            c.getValue().size());
                    c.getValue()
                            .stream()
                            .sorted((s1, s2) -> s1.compareTo(s2))
                            .forEach(s -> System.out.printf("-- %s%n", s));
                });
    }
}
