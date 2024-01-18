import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Main {

    private static final String[] INGREDIENTS = {"flour", "butter", "baking soda", "sugar", "royal icing", "egg"};
    private static final double[] INGREDIENTS_PER_BATCH = {2, 0.25, 1.5, 3, 0.5, 1};

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("//Users//ben//IdeaProjects//CS3//Cookies//src//cookies.dat"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                int numOrders = Integer.parseInt(parts[0]);
                String firstName = parts[5];
                String lastName = parts[6];

                if (isShrank(firstName, lastName)) {
                    System.out.println("DO NOT SELL!!!");
                } else {
                    printShoppingList(numOrders, firstName + " " + lastName);
                }

                System.out.println(); // Separate test cases with an empty line
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: cookies.dat");
        }
    }

    private static boolean isShrank(String firstName, String lastName) {
        char charArray[] = firstName.toLowerCase().toCharArray();
        Arrays.sort(charArray);

        char charArray2[] = lastName.toLowerCase().toCharArray();
        Arrays.sort(charArray2);
        return new String(charArray).equals("ahknrs") || new String(charArray2).toString().equals("ahknrs");
    }

    private static void printShoppingList(int numOrders, String name) {
        System.out.println("Shopping list for " + name + "'s order:");
        for (int i = 0; i < INGREDIENTS.length; i++) {
            double amount = numOrders * INGREDIENTS_PER_BATCH[i];
            System.out.printf("%.2f %s %s%n", amount, getUnit(amount, INGREDIENTS[i]), INGREDIENTS[i]);
        }
    }

    private static String getUnit(double amount, String ingredient) {
        if (amount == 1 && !ingredient.equals("egg")) {
            return "cup of";
        } else if (ingredient.equals("baking soda")) {
            return "teaspoon"; // Always singular for baking soda
        } else {
            return "cups of";
        }
    }
}
