import static java.lang.System.*;
import java.util.*;

public class MathSet
{
	private Set<Integer> one;
	private Set<Integer> two;




	public MathSet(String o, String t)
	{
		one = new HashSet<>();
		String[] numo = o.split(" ");
		for (String number : numo) {
			one.add(Integer.parseInt(number));
		}
		two = new HashSet<>();
		String[] numt = t.split(" ");
		for (String number : numt) {
			two.add(Integer.parseInt(number));
		}

	}

	public Set<Integer> union()
	{
		Set<Integer> union = new HashSet<>(one);
		union.addAll(two);
		return union;
	}

	public Set<Integer> intersection()
	{
		Set<Integer> intersection = new HashSet<>(one);
		intersection.retainAll(two);
		return intersection;
	}

	public Set<Integer> differenceAMinusB()
	{
		Set<Integer> difference = new HashSet<>(one);
		difference.removeAll(two);
		return difference;
	}

	public Set<Integer> differenceBMinusA()
	{
		Set<Integer> difference = new HashSet<>(two);
		difference.removeAll(one);
		return difference;
	}

	public Set<Integer> symmetricDifference()
	{
		Set<Integer> symmetricDifference = new HashSet<>(one);
		symmetricDifference.addAll(two);
		symmetricDifference.removeAll(intersection());
		return symmetricDifference;
	}
	
	public String toString()
	{
		return "Set one " + one + "\n" +	"Set two " + two +  "\n";
	}
}