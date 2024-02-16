import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GraphRunner {

	public static void main(String[] args) {
		// Handle potential file not found exception
		try {
			Scanner file = new Scanner(new File("//Users//ben//IdeaProjects//CS3//Graphs 1//src//graph1.dat"));

			int howManyTimes = file.nextInt();
			file.nextLine(); // Consume newline after number of tests

			for (int x = 0; x < howManyTimes; x++) {
				String connectionsLine = file.nextLine();
				Graph graph = new Graph(connectionsLine);

				String first = file.next();
				String second = file.next();

				boolean connected = graph.isConnected(first, second);

				// Print the result with proper formatting
				System.out.printf("%s connects to %s == %s\n", first, second, connected ? "yes" : "no");
				file.nextLine(); // Consume newline after each query
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found. Please check the file path.");
		}
	}
}
