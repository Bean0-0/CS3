import java.util.*;

public class ShortestPathGraph {

	private Map<String, List<String>> graph;

	public ShortestPathGraph() {
		this.graph = new HashMap<>();
	}

	public void addConnection(String start, String end) {
		List<String> connections = graph.getOrDefault(start, new ArrayList<>());
		connections.add(end);
		graph.put(start, connections);

		// Ensure bidirectional connection (if not already present):
		List<String> reverseConnections = graph.getOrDefault(end, new ArrayList<>());
		if (!reverseConnections.contains(start)) {
			reverseConnections.add(start);
			graph.put(end, reverseConnections);
		}
	}

	public boolean isConnected(String start, String end) {
		if (!graph.containsKey(start)) {
			return false;
		}

		// Use an efficient Breadth-First Search (BFS) for path existence:
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		Set<String> visited = new HashSet<>();
		visited.add(start);

		while (!queue.isEmpty()) {
			String current = queue.poll();
			if (current.equals(end)) {
				return true;
			}

			List<String> neighbors = graph.get(current);
			if (neighbors != null) {
				for (String neighbor : neighbors) {
					if (!visited.contains(neighbor)) {
						queue.add(neighbor);
						visited.add(neighbor);
					}
				}
			}
		}

		return false;
	}

	public int findShortestPath(String start, String end) {
		if (!graph.containsKey(start) || !graph.containsKey(end)) {
			return -1; // Indicate nodes not in the graph
		}

		// Use Dijkstra's algorithm for efficient shortest path:
		Map<String, Integer> distances = new HashMap<>();
		for (String node : graph.keySet()) {
			distances.put(node, Integer.MAX_VALUE);
		}
		distances.put(start, 0); // Start node distance is 0

		Queue<String> pq = new PriorityQueue<>((v1, v2) -> distances.get(v1) - distances.get(v2));
		pq.add(start);

		Set<String> visited = new HashSet<>();
		while (!pq.isEmpty()) {
			String current = pq.poll();
			if (visited.contains(current)) {
				continue; // Skip already visited nodes
			}
			visited.add(current);

			if (current.equals(end)) {
				return distances.get(current); // Found shortest path
			}

			List<String> neighbors = graph.get(current);
			if (neighbors != null) {
				for (String neighbor : neighbors) {
					int newDistance = distances.get(current) + 1; // Assume unit edge weights
					if (newDistance < distances.get(neighbor)) {
						distances.put(neighbor, newDistance);
						pq.add(neighbor);
					}
				}
			}
		}

		return -1; // No path found
	}
}
