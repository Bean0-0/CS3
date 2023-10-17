import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class Acronyms
{
	private Map<String,String> acronymTable;

	public Acronyms()
	{
		acronymTable = new TreeMap<>();
	}

	public void putEntry(String entry)
	{
		String[] parts = entry.split("-");
		acronymTable.put(parts[0].trim(), parts[1]);
	}

	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output = "";
		while (chop.hasNext()) {
			String word = chop.next().replace(".","");
			if (acronymTable.containsKey(word)) {
				output += acronymTable.get(word) + " ";
			} else {
				output += word + " ";
			}
		}
		return output;
	}

	public String toString()
	{
		String output = "";
		for (String key : acronymTable.keySet()) {
			output += key + "=" + acronymTable.get(key) + "\n";
		}
		return output;
	}
}