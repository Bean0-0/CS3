import java.util.*;

public class ShortestPathGraph {

	private final Map<String, List<String>> graph;

	public ShortestPathGraph(String[] connections) {
		this.graph = new HashMap<>();
		for (String connection : connections) {
			char[] nodes = connection.toCharArray();
			String node1 = String.valueOf(nodes[0]);
			String node2 = String.valueOf(nodes[1]);
			List<String> neighbors = graph.getOrDefault(node1, new ArrayList<>());
			neighbors.add(node2);
			graph.put(node1, neighbors);
			neighbors = graph.getOrDefault(node2, new ArrayList<>());
			neighbors.add(node1); // Bi-directional connection
			graph.put(node2, neighbors);
		}
	}

	public boolean isConnected(String first, String second) {
		if (!graph.containsKey(first) || !graph.containsKey(second)) {
			return false;
		}

		return findShortestPath(first, second) != null;
	}

	public List<String> findShortestPath(String first, String second) {
		if (!graph.containsKey(first) || !graph.containsKey(second)) {
			return null;
		}

		Queue<String> queue = new LinkedList<>();
		Map<String, String> prev = new HashMap<>(); // Track parent nodes for backtracking
		Set<String> visited = new HashSet<>();

		queue.add(first);
		prev.put(first, null); // Mark starting node as null
		visited.add(first);

		while (!queue.isEmpty()) {
			String current = queue.poll();
			if (current.equals(second)) {
				break;
			}

			for (String neighbor : graph.get(current)) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					prev.put(neighbor, current);
					visited.add(neighbor);
				}
			}
		}

		if (!prev.containsKey(second)) { // No path found
			return null;
		}

		List<String> path = new ArrayList<>();
		path.add(second);
		String node = prev.get(second);
		while (node != null) {
			path.add(0, node); // Add nodes in reverse order to get the actual path
			node = prev.get(node);
		}

		return path;
	}


}