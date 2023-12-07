import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import static java.lang.System.*;

public class HashTableRunner {

	public static void main(String[] args) {
		try {
			HashTable table = new HashTable();

			File file = new File("//Users//ben//IdeaProjects//CS3//Hashtable 1//src//numbers.dat");
			Scanner scanner = new Scanner(file);

			// Load data into the hash table
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				int value = Integer.parseInt(line.strip());
				table.add(value);
			}

			out.println(table);

		} catch (Exception e) {
			out.println("Houston, we have a problem!");
			e.printStackTrace();
		}
	}
}
