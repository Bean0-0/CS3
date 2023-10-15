import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;

public class Relatives
{
	private Map<String,Set<String>> map;

	public Relatives()
	{
		map = new TreeMap<>();
	}

	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");
		String person = personRelative[0];
		String relative = personRelative[1];

		Set<String> relatives = map.getOrDefault(person, new TreeSet<>());
		relatives.add(relative);
		map.put(person, relatives);
	}


	public String getRelatives(String person)
	{
		Set<String> relatives = map.get(person);
		if (relatives == null) {
			return "";
		}

		return relatives.stream().reduce((a, b) -> a + ", " + b).orElse("");
	}


	public String toString()
	{
		String output = "";
		for (String person : map.keySet()) {
			output += person + " is related to " + getRelatives(person) + "\n";
		}
		return output;
	}
}