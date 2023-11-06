import java.util.ArrayList;
import static java.lang.System.*;

public class IntQueue
{
	private ArrayList<Integer> listOfInts;

	public IntQueue()
	{
		listOfInts = new ArrayList<>();
	}

	public void add(int item)
	{
		listOfInts.add(item);
	}

	public int remove()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}
		return listOfInts.remove(0);
	}

	public boolean isEmpty()
	{
		return listOfInts.isEmpty();
	}

	public int peek()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}
		return listOfInts.get(0);
	}

	public String toString()
	{
		return listOfInts.toString();
	}
}
