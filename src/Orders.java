import java.util.LinkedHashMap;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Double> productPrice = new LinkedHashMap<>();
        LinkedHashMap<String, Double> remember = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] tokens = input.split(" ");

            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            double quantity = Double.parseDouble(tokens[2]);

            if (!productPrice.containsKey(product)) {
                productPrice.put(product, price * quantity);
                remember.put(product, quantity);
            } else {
                remember.put(product, remember.get(product) + quantity);
                productPrice.put(product, remember.get(product) * price);
            }

            input = scanner.nextLine();
        }
        productPrice.entrySet().stream().forEach(p -> System.out.printf("%s -> %.2f%n", p.getKey(), p.getValue()));
    }
}
