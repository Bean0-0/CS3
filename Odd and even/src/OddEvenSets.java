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
	public static boolean isPerfect (int n)
	{
		if (n == 1)
			return false;
		int sum = 1;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				sum += 1;
			}
		}
        return sum == n;
    }

	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}

}