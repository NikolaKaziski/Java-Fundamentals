import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<String>> users = new HashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")) {
            String[] tokens = null;
            if (input.contains("|")) {
                tokens = input.split(" \\| ");

                String forceSide = tokens[0];
                String forceUser = tokens[1];

                users.putIfAbsent(forceSide, new ArrayList<>());
                boolean isPresent = false;
                for (Map.Entry<String, List<String>> entry : users.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        isPresent = true;
                        break;
                    }
                }
                if (!users.get(forceSide).contains(forceUser) && !isPresent) {
                    users.get(forceSide).add(forceUser);
                }
            } else {
                tokens = input.split(" -> ");
                String forceSide = tokens[1];
                String forceUser = tokens[0];

                boolean isPresent = false;

                for (Map.Entry<String, List<String>> entry : users.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        entry.getValue().remove(forceUser);
                        users.putIfAbsent(forceSide, new ArrayList<>());
                        users.get(forceSide).add(forceUser);
                        isPresent = true;
                        break;
                    }
                }
                if (!isPresent) {
                    users.putIfAbsent(forceSide, new ArrayList<>());
                    users.get(forceSide).add(forceUser);

                }

                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }
        users.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().size() - f.getValue().size();
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(e -> {
            if (e.getValue().size() != 0) {
                System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                e.getValue().stream().sorted(String::compareTo).forEach(user -> System.out.println("! " + user));
            }
        });

    }
}
