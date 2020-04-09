import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> companyId = new HashMap<>();


        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String id = tokens[1];

            if (!companyId.containsKey(company)) {
                companyId.put(company, new LinkedList<>());
                companyId.get(company).add(id);
            } else {
                if (!companyId.get(company).contains(id)) {
                    companyId.get(company).add(id);
                }

            }


            input = scanner.nextLine();
        }
        companyId
                .entrySet()
                .stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(id -> System.out.println("-- " + id));
                });
    }
}
