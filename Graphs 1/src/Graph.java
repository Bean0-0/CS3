import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Graph {
	private final Set<String> connections;

	public Graph(String connectionsLine) {
		connections = new HashSet<>();
		parseConnections(connectionsLine);
	}

	// Efficiently parse connections and create bidirectional relationships
	private void parseConnections(String connectionsLine) {
		String[] parts = connectionsLine.split(" ");
		for (int i = 1; i < parts.length; i++) {
			connections.add(parts[0] + parts[i]);
			connections.add(parts[i] + parts[0]); // Bidirectional
		}
	}

	// Improved depth-first search (DFS) for robust connectivity checking
	public boolean isConnected(String first, String second) {
		if (!connections.contains(first) || !connections.contains(second)) {
			return false; // Either node doesn't exist
		}
		Set<String> visited = new HashSet<>();
		return dfs(first, second, visited);
	}

	private boolean dfs(String node, String target, Set<String> visited) {
		if (visited.contains(node)) {
			return false; // Avoid revisiting nodes for efficiency
		}
		if (node.equals(target)) {
			return true; // Found the target
		}
		visited.add(node);
		for (String neighbor : connections) {
			if (neighbor.startsWith(node)) { // Efficiently check connections starting with current node
				if (dfs(neighbor.substring(1), target, visited)) {
					return true;
				}
			}
		}
		return false;
	}
}