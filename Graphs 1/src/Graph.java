import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

public class Graph {

	private TreeMap<String, List<String>> map; // Map to store connections
	private boolean found; // Flag to indicate if a connection is found

	public Graph(String line) {
		// Initialize the map
		map = new TreeMap<>();
		// Process the input line to create connections
		String[] connections = line.split(" ");
		for (int i = 0; i < connections.length; i += 2) {
			addConnection(connections[i], connections[i + 1]);
			addConnection(connections[i + 1], connections[i]); // Bi-directional
		}
	}

	public boolean contains(String letter) {
		// Check if the letter exists as a key in the map
		return map.containsKey(letter);
	}

	public void check(String first, String second, String placesUsed) {
		// Base case: If a direct connection exists, set found to true and return
		if (map.get(first).contains(second)) {
			found = true;
			return;
		}

		// Recursive case: Explore connected nodes
		for (String neighbor : map.get(first)) {
			if (!placesUsed.contains(neighbor)) {
				// Add neighbor to visited nodes
				placesUsed += neighbor;
				// Recursively check from the neighbor
				check(neighbor, second, placesUsed);
				// If found, no need to explore further
				if (found) {
					return;
				}
			}
		}
	}

	public String toString() {
		// Format the map as a string representation of the graph
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			sb.append(entry.getKey()).append(" connects to: ");
			sb.append(String.join(", ", entry.getValue())).append("\n");
		}
		return sb.toString();
	}

	private void addConnection(String node1, String node2) {
		// Add a connection between two nodes
		List<String> connections = map.getOrDefault(node1, new ArrayList<>());
		connections.add(node2);
		map.put(node1, connections);
	}
}
