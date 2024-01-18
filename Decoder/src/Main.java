import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("//Users//ben//IdeaProjects//CS3//Decoder//src//decoder.dat");
            Scanner scanner = new Scanner(file);

            int numTestCases = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numTestCases; i++) {
                String encodedNames = scanner.nextLine();
                String decodedNames = decodeNames(encodedNames);
                System.out.println(decodedNames);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: decoder.dat");
        }
    }

    private static String decodeNames(String encodedNames) {
        StringBuilder decodedBuilder = new StringBuilder();
        ArrayList<Character> nameBuilder = new ArrayList<>();

        for (char c : encodedNames.toCharArray()) {
            if (Character.isLetter(c)) {
                nameBuilder.add(c);
            } else if (c == '%') {
                char first = nameBuilder.remove(nameBuilder.size() - 1);
                char second = nameBuilder.remove(nameBuilder.size() - 1);
                nameBuilder.add(first);
                nameBuilder.add(second);
            } else if (c == '1') {
                nameBuilder.remove(nameBuilder.size() - 1);
            } else if (c == '2') {
                nameBuilder.remove(nameBuilder.size() - 2);
            } else if (c == '+') {
                decodedBuilder.append(toUpperCase(nameBuilder)).append(" ");
                nameBuilder.clear();
            }
        }

        decodedBuilder.append(toUpperCase(nameBuilder)); // Add the last name
        return decodedBuilder.toString();
    }

    private static String toUpperCase(ArrayList<Character> characters) {
        StringBuilder builder = new StringBuilder();
        for (char c : characters) {
            builder.append(Character.toUpperCase(c));
        }
        return builder.toString();
    }
}
