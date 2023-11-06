import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class PalinList
{
	private Queue<String> queue;
	private Stack<String> stack;

	public PalinList()
	{
		setList("");
	}

	public PalinList(String list)
	{
		queue = new LinkedList<>();
		stack = new Stack<>();

		for (String word : list.split(" ")) {
			queue.add(word);
			stack.push(word);
		}
	}

	public void setList(String list)
	{
		queue = new LinkedList<>();
		stack = new Stack<>();

		for (String word : list.split(" ")) {
			queue.add(word);
			stack.push(word);
		}
	}

	public boolean isPalin()
	{
		while (!queue.isEmpty()) {
			if (!queue.poll().equals(stack.pop())) {
				return false;
			}
		}

		return true;
	}


	@Override
	public String toString() {
		return queue.toString();
	}
}