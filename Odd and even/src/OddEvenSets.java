import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets
{
	private Set<Integer> odds;
	private Set<Integer> evens;

	public OddEvenSets(String line)
	{
		odds = new TreeSet<>();
		evens = new TreeSet<>();
		String[] numbers = line.split(" ");
		for (String number : numbers) {
			int num = Integer.parseInt(number);
			if (num % 2 == 0) {
				evens.add(num);
			} else {
				odds.add(num);
			}
		}
	}

	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}

}