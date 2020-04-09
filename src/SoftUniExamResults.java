import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> users = new TreeMap<>();
        HashMap<String, Integer> languages = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String username = tokens[0];
            String language = tokens[1];

            if (language.equals("banned")) {
                users.remove(username);
                input = scanner.nextLine();
                continue;
            }
            int currentPoints = Integer.parseInt(tokens[2]);

            if (!users.containsKey(username)) {
                users.put(username, currentPoints);
            } else {
                int points = users.get(username);
                if (points < currentPoints) {
                    users.put(username, currentPoints);
                }
            }
            if (!languages.containsKey(language)) {
                languages.put(language, 1);
            } else {
                int count = languages.get(language) + 1;
                languages.put(language, count);
            }
            input = scanner.nextLine();
        }

        System.out.println("Results:");

        users.entrySet().stream().sorted((f, s) -> {
            return s.getValue().compareTo(f.getValue());
        }).forEach(entry -> {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        });

        System.out.println("Submissions:");
        languages.entrySet().stream().forEach(b -> {
            System.out.printf("%s - %d%n", b.getKey(), b.getValue());
        });
    }
}
