import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RightStuff {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("//Users//ben//IdeaProjects//CS3//Righstuff//src//rightstuff.dat")); // Update file path

        double numDataSets = scanner.nextDouble(); // Change to int

        for (int i = 0; i < numDataSets; i++) {
            double acceptedValue = scanner.nextDouble();
            int dataSize = (int)scanner.nextDouble();
            double[] data = new double[dataSize - 1]; // Correct data array size

            for (int j = 0; j < data.length; j++) {
                data[j] = scanner.nextDouble();
            }

            String result = "";

            // Calculate accuracy
            double average = calculateAverage(data);
            double percentError = Math.abs(average - acceptedValue) / acceptedValue * 100;
            if (percentError <= 5) {
                result += "Accurate";
            }

            // Calculate precision
            double range = calculateRange(data);
            double precisionRatio = range / average * 100;
            if (precisionRatio <= 10) {
                result += " Precise";
            }

            // Print result
            if (result.isEmpty()) {
                System.out.println("Neither");
            } else {
                System.out.println(result.trim());
            }
        }

        scanner.close();
    }

    private static double calculateAverage(double[] data) {
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.length;
    }

    private static double calculateRange(double[] data) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double value : data) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return max - min;
    }
}
