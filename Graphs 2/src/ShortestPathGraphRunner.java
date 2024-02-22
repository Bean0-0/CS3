import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathGraphRunner{
public static void main(String[] args) {
	ShortestPathGraph graph = new ShortestPathGraph();

	graph.addConnection("A", "B");
	graph.addConnection("B", "C");
	graph.addConnection("C", "D");
	graph.addConnection("A", "D");

	System.out.println("Is A connected to D? " + graph.isConnected("A", "D"));

	int shortestPath = graph.findShortestPath("A", "D");
	System.out.println("Shortest path from A to D: " + shortestPath);
	}
}
