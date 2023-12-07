import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.System.*;

public class HashTable {

	private LinkedList<Object>[] table;

	public HashTable() {
		table = new LinkedList[10];
	}

	public void add(Object obj) {
		int i = (int)obj%10;

		// Create the linked list if it doesn't exist
		if (table[i] == null) {
			table[i] = new LinkedList<>();
		}

		// Add the object to the existing or newly created list
		table[i].add(obj);
	}

	public String toString() {
		String output = "HASHTABLE\n";

		for (int i = 0; i < table.length; i++) {
			output += "bucket " + i + " ";

			if (table[i] != null) {
				for (Object obj : table[i]) {
					output += obj + " ";
				}
			}

			output += "\n";
		}

		return output;
	}
}
