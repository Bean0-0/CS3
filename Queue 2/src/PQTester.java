import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQTester
{
	private Queue<String> pQueue;

	public PQTester()
	{
		pQueue = new PriorityQueue<>();
	}

	public PQTester(String list)
	{
		pQueue = new PriorityQueue<>(Arrays.asList(list.split(" ")));
	}

	public void setPQ(String list)
	{
		pQueue = new PriorityQueue<>(Arrays.asList(list.split(" ")));
	}

	public String getMin()
	{
		return pQueue.peek();
	}

	public String getNaturalOrder()
	{
		String output = "";
		while (!pQueue.isEmpty()) {
			output += pQueue.poll() + " ";
		}
		return output;
	}

	@Override
	public String toString() {
		return pQueue.toString();
	}
}