import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            int count = Integer.parseInt(scanner.nextLine());

            resources.putIfAbsent(input, 0);

            int oldCount = resources.get(input);
            
            resources.put(input, oldCount + count);

            input = scanner.nextLine();
        }
        resources.entrySet().forEach(r -> System.out.printf("%s -> %d%n",r.getKey(),r.getValue()));
    }
}
