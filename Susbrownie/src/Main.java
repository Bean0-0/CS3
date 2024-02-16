import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static final char KENNY = 'K';
    private static final char SPECIAL_INGREDIENT = 'S';
    private static final char OVEN = 'O';
    private static final char[] INGREDIENTS = {'E', 'F', 'C', 'B'};
    private static final char[] BLOCKED_SPACES = {'#', 'A'};

    public static void main(String[] args) throws FileNotFoundException {
        // Read the file
        File file = new File("susbrownie.dat");
        Scanner scanner = new Scanner(file);

        // Read number of test cases
        int numTestCases = scanner.nextInt();

        // Loop through each test case
        for (int i = 0; i < numTestCases; i++) {
            // Read grid dimensions
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            // Read the grid
            char[][] grid = new char[rows][columns];
            for (int r = 0; r < rows; r++) {
                String line = scanner.nextLine();
                for (int c = 0; c < columns; c++) {
                    grid[r][c] = line.charAt(c);
                }
            }

            // Find starting position of Kenny
            int kennyRow = 0;
            int kennyCol = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    if (grid[r][c] == KENNY) {
                        kennyRow = r;
                        kennyCol = c;
                        break;
                    }
                }
            }

            // Start exploring the grid
            boolean success = exploreGrid(grid, kennyRow, kennyCol, new boolean[rows][columns]);

            // Print the result
            if (success) {
                System.out.println("Kenny was able to bake brownies in complete secrecy!");
            } else if (!hasAllIngredients(grid)) {
                System.out.println("Kenny can't bake brownies :(");
            } else {
                System.out.println("Kenny got caught by the police...");
            }
        }

        scanner.close();
    }

    private static boolean exploreGrid(char[][] grid, int row, int col, boolean[][] visited) {
        // Mark current position as visited
        visited[row][col] = true;

        // Check if all ingredients collected and reached oven
        if (hasAllIngredients(grid) && grid[row][col] == OVEN) {
            return true;
        }

        // Explore all four directions
        for (int[] direction : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Check if valid position and not visited
            if (isValidPosition(grid, newRow, newCol) && !visited[newRow][newCol]) {
                if (grid[newRow][newCol] == SPECIAL_INGREDIENT) {
                    // If special ingredient found, avoid authorities from that point
                    return exploreWithoutPolice(grid, newRow, newCol, visited);
                } else if (exploreGrid(grid, newRow, newCol, visited)) {
                    return true; // Success from child path
                }
            }
        }

        // No successful path found
        return false;
    }

    private static boolean exploreWithoutPolice(char[][] grid, int row, int col, boolean[][] visited) {
        // Explore without checking for authorities
        for (int[] direction : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValidPosition(grid, newRow, newCol) && !visited[newRow][newCol]) {
                if (exploreWithoutPolice(grid, newRow, newCol, visited)) {
                    return true; // Success from child path
                }
            }
        }
        return false;
    }
}