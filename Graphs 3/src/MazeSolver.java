import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MazeSolver {

    private char[][] maze;
    private int rows, cols;
    private final char WALL = '#';
    private final char SPACE = '.';
    private final char VISITED = 'V';

    public static void main(String[] args) {
        MazeSolver solver = new MazeSolver();
        try {
            solver.solveMaze("C:\\Users\\benja\\IdeaProjects\\CS3\\Graphs 3\\src\\maze_short-1.dat");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Maze file not found.");
        }
    }

    public void solveMaze(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        rows = scanner.nextInt();
        // cols = scanner.nextInt();
        maze = new char[rows][rows];

        for (int i = 0; i < rows; i++) {
            maze[i] = scanner.next().toCharArray();
        }

        int steps = findShortestPath(0, 0);

        if (steps == -1) {
            System.out.println("No exit found.");
        } else {
            System.out.println("Shortest path:");
            printMaze();
            System.out.println("Steps: " + steps);
        }
    }

    private int findShortestPath(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return -1; // Out of bounds
        }
        if (maze[row][col] == WALL || maze[row][col] == VISITED) {
            return -1; // Wall or visited
        }
        if (row == rows - 1 && col == cols - 1) {
            return 0; // Exit reached
        }

        maze[row][col] = VISITED; // Mark as visited

        int[] dx = {0, 1, 0, -1}; // Right, down, left, up
        int[] dy = {1, 0, -1, 0};

        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            int steps = findShortestPath(newRow, newCol);
            if (steps >= 0 && steps < minSteps) {
                minSteps = steps + 1; // Add current step
            }
        }

        maze[row][col] = SPACE; // Unmark for backtracking

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }

    private void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
