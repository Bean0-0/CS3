import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathGraphRunner
{
public static void main(String[] args) {
		String[] connections = { "AB", "BC", "CD", "DE", "CE", "CA", "XY", "RS", "YS", "ST", "TB", "BD", "RJ", "PQ", "QX", "AX", "BH", "CH", "DX", "EX", "FX", "GH", "AE", "BC", "CD", "DE", "FD", "TH", "PT", "EI", "IO", "OU", "AG", "HI", "HJ", "HK", "KQ", "KM", "KN", "MO", "MP", "MQ", "HQ", "AI", "TV", "XY", "AZ", "XT", "JK", "KL", "LT", "JX", "MN", "TN", "JL", "NO", "OP", "PT", "NX", "VZ", "IB", "DT", "IX", "VX", "CX", "DX", "MX", "LX", "BY" };
		ShortestPathGraph graph = new ShortestPathGraph(connections);

		String[] tests = { "C", "D", "P", "T", "A", "G", "H", "Q", "A", "I", "V", "Z", "A", "Z", "D", "T", "I", "B" };
		for (String test : tests) {
			String first = test.substring(0, 1);
			String second = test.substring(1);
			boolean connected = graph.isConnected(first, second);
			List<String> path = graph.findShortestPath(first, second);

		}
	}
}