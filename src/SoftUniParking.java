import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> parking = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String username = tokens[1];

            if (command.equals("register")) {
                String number = tokens[2];
                if (parking.containsKey(username)) {
                    String id = parking.get(username);
                    System.out.printf("ERROR: already registered with plate number %s %n", number);
                } else {
                    parking.put(username, number);
                    System.out.printf("%s registered %s successfully %n", username, number);
                }
            } else {
                if (parking.containsKey(username)) {
                    parking.remove(username);
                    System.out.printf("%s unregistered successfully %n", username);
                } else {
                    System.out.printf("ERROR: user %s not found %n", username);
                }
            }
        }
        parking.entrySet().forEach(u -> System.out.printf("%s => %s %n", u.getKey(), u.getValue()));
    }
}
