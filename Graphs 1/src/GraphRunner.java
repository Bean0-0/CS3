import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("//Users//ben//IdeaProjects//CS3//Graphs 1//src//graph1.dat"));
		int howManyTimes = file.nextInt();
		file.nextLine();
		for(int x=0; x<howManyTimes; x++)
		{
			String connectionsLine = file.nextLine();
			Graph graph = new Graph(connectionsLine);

			String first = file.next();
			String second = file.next();

			boolean found = false;

			// Start the recursive check
			graph.check(first, second, first); // Initial placesUsed includes first

			// Print the result
			out.println(first + " connects to " + second + " == " + (found ? "yes" : "no"));
			file.nextLine(); // Consume the extra newline
		}
	}
}