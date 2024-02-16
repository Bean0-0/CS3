import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("//Users//ben//IdeaProjects//CS3//LeftOver//src//leftover.dat");
        Scanner scanner = new Scanner(file);

        int numTestCases = scanner.nextInt(); // Read number of test cases

        for (int i = 0; i < numTestCases; i++) {
            int numPeople = scanner.nextInt(); // Read number of people
            int totalPizzas = scanner.nextInt(); // Read total pizzas bought

            double totalEaten = 0; // Track total pizza eaten by everyone

            for (int j = 0; j < numPeople; j++) {
                scanner.next(); // Skip name (not used in this solution)
                double amountEaten = scanner.nextDouble(); // Read amount eaten by one person
                totalEaten += amountEaten;
            }

            // Check if there is leftover pizza
            if (totalPizzas * 8 > totalEaten) { // 8 slices per pizza
                System.out.println("Leftover for Bowen");
            } else {
                System.out.println("Bowen's crying");
            }
        }

        scanner.close();
    }
}
