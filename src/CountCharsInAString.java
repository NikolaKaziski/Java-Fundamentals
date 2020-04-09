import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        LinkedHashMap<Character, Integer> letters = new LinkedHashMap<>();

        for (char letter : input) {
            if (letter == ' ') {
                continue;
            }
            letters.putIfAbsent(letter, 0);
            int count = letters.get(letter);
            letters.put(letter, count + 1);
        }
        letters.entrySet().forEach(e -> System.out.printf("%c -> %d%n", e.getKey(), e.getValue()));
    }
}
