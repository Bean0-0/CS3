import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String[] WORST_STUDENTS = {"Nik.S", "Bow.Y", "Hen.F", "Tro.D", "Bra.B", "Jar.A"};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("//Users//ben//IdeaProjects//CS3//SeatingChart//src//seating.dat"));
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int period = scanner.nextInt();
            scanner.next();
            List<String> students = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));

            int sideLength = (int) Math.ceil(Math.sqrt(students.size()));
            String[][] seatingChart = createSeatingChart(students, sideLength);

            printSeatingChart(period, seatingChart);

            if (i < t - 1) {
                System.out.println(); // Add an empty line between test cases
            }
        }
    }

    private static String[][] createSeatingChart(List<String> students, int sideLength) {
        String[][] seatingChart = new String[sideLength][sideLength];
        int row = 0, col = 0, direction = 0; // 0: right, 1: down, 2: left, 3: up

        // Place worst students first
        for (String worstStudent : WORST_STUDENTS) {
            if (students.remove(worstStudent)) {
                seatingChart[row][col] = worstStudent;
                moveAndFillSeat(seatingChart, row, col, sideLength, direction);
            }
        }

        // Place remaining students
        for (String student : students) {
            seatingChart[row][col] = student;
            moveAndFillSeat(seatingChart, row, col, sideLength, direction);
        }

        return seatingChart;
    }

    private static void moveAndFillSeat(String[][] seatingChart, int row, int col, int sideLength, int direction) {
        switch (direction) {
            case 0: // Right
                col++;
                if (col == sideLength || seatingChart[row][col] != null) {
                    direction = 1;
                    row++;
                }
                break;
            case 1: // Down
                row++;
                if (row == sideLength || seatingChart[row][col] != null) {
                    direction = 2;
                    col--;
                }
                break;
            case 2: // Left
                col--;
                if (col < 0 || seatingChart[row][col] != null) {
                    direction = 3;
                    row--;
                }
                break;
            case 3: // Up
                row--;
                if (row < 0 || seatingChart[row][col] != null) {
                    direction = 0;
                    col++;
                }
                break;
        }
    }

    private static void printSeatingChart(int period, String[][] seatingChart) {
        System.out.println("Period " + period);
        System.out.println("-".repeat(10));

        for (String[] row : seatingChart) {
            for (String seat : row) {
                System.out.printf("%-5s", seat == null ? " " : seat);
            }
            System.out.println();
        }
    }
}
