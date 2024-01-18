import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("//Users//ben//IdeaProjects//CS3//Ingredients//src//Ingredients.dat"));
        int tests = sc.nextInt();

        for (int i = 0; i < tests; i++) {
            int boughtCount = sc.nextInt();
            int recipeCount = sc.nextInt();

            HashSet<Integer> bought = new HashSet<>();
            for (int j = 0; j < boughtCount; j++) {
                bought.add(sc.nextInt());
            }

            HashSet<Integer> recipe = new HashSet<>();
            for (int j = 0; j < recipeCount; j++) {
                recipe.add(sc.nextInt());
            }

            boolean hasAllRegular = true;
            boolean hasSpecial = false;

            for (int ingredient : recipe) {
                if (ingredient == 1) {
                    hasSpecial = true;
                } else if (!bought.contains(ingredient)) {
                    hasAllRegular = false;
                    break;
                }
            }

            if (hasSpecial && hasAllRegular) {
                System.out.println("Time to take a trip to the stratosphere!");
            } else if (hasAllRegular) {
                System.out.println("I guess it’s time to have a normal brownie…");
            } else {
                System.out.println(":(");
            }
        }
    }
}
