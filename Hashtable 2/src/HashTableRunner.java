import java.io.File;
import java.util.*;
public class HashTableRunner {
	public static void main(String[] args) {
		try {
			// 1. Make a new table
			HashTable table = new HashTable();

			// 2. Read from the file
			String filename = "data.txt"; // Replace "data.txt" with the actual filename
			Scanner scanner = new Scanner(new File("//Users//ben//IdeaProjects//CS3//Hashtable 2//src//words.dat"));

			// 3. Load stuff into the table
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Word word = new Word(line);
				table.add(word);
			}
			scanner.close();

			// 4. Print out the table
			System.out.println(table.toString());
		} catch (Exception e) {
			System.out.println("Houston, we have a problem!");
			e.printStackTrace();
		}
	}
}
