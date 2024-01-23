import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("//Users//ben//IdeaProjects//CS3//Players//src//players.dat"));

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int numChefs = scanner.nextInt();

            List<Chef> chefs = new ArrayList<>();
            for (int j = 0; j < numChefs; j++) {
                String line = scanner.nextLine();
                String[] parts = line.split(" - ");
                String name = parts[0];
                double height = Double.parseDouble(parts[1]);
                double threePointPercentage = Double.parseDouble(parts[2]);
                int position = Integer.parseInt(parts[3]);
                double verticalJump = Double.parseDouble(parts[4]);
                int weight = Integer.parseInt(parts[5]);

                if (weight < 175) {
                    continue; // Skip chefs under 175 pounds
                }

                Chef chef = new Chef(name, height, threePointPercentage, position, verticalJump, weight);
                chefs.add(chef);
            }

            Collections.sort(chefs, new ChefComparator());

            printRankings(chefs);
            System.out.println("***************");
        }

        scanner.close();
    }

    private static void printRankings(List<Chef> chefs) {
        for (int i = 0; i < chefs.size(); i++) {
            Chef chef = chefs.get(i);
            String positionName = getPositionName(chef.position);
            System.out.printf("#%d: %s - %s\n", i + 1, chef.name, positionName);
        }
    }

    private static String getPositionName(int position) {
        switch (position) {
            case 1:
                return "point guard";
            case 2:
                return "shooting guard";
            case 3:
                return "small forward";
            case 4:
                return "power forward";
            case 5:
                return "center";
            default:
                return "unknown";
        }
    }

    private static class Chef {
        String name;
        double height;
        double threePointPercentage;
        int position;
        double verticalJump;
        int weight;

        public Chef(String name, double height, double threePointPercentage, int position, double verticalJump, int weight) {
            this.name = name;
            this.height = height;
            this.threePointPercentage = threePointPercentage;
            this.position = position;
            this.verticalJump = verticalJump;
            this.weight = weight;
        }
    }

    private static class ChefComparator implements Comparator<Chef> {

        @Override
        public int compare(Chef chef1, Chef chef2) {
            // Prioritize shooting ability
            if (chef1.threePointPercentage != chef2.threePointPercentage) {
                return Double.compare(chef2.threePointPercentage, chef1.threePointPercentage);
            }

            // Prioritize height
            if (chef1.height != chef2.height) {
                return Double.compare(chef2.height, chef1.height);
            }

            // Prioritize lower position (guard-centric)
            if (chef1.position != chef2.position) {
                return Integer.compare(chef1.position, chef2.position);
            }

            // Prioritize vertical jump
            if (chef1.verticalJump != chef2.verticalJump) {
                return Double.compare(chef2.verticalJump, chef1.verticalJump);
            }

            // Prioritize weight (least important)
            if (chef1.weight != chef2.weight) {
                return Integer.compare(chef2.weight, chef1.weight);
            }

            // Alphabetical order if all stats are equal
            return chef1.name.compareTo(chef2.name);
        }
    }
}
