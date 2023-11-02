import java.util.Stack;
import static java.lang.System.*;


public class StackTest
{
	private Stack<String> stack;




	public StackTest()
	{
		stack = new Stack<String>();
	}


	public StackTest(String line)
	{
		String[] splitLine = line.split(" ");


		stack = new Stack<String>();


		for( int index = 0; index < splitLine.length ; index ++) {


			stack.push(splitLine[index]);
		}
		out.println(stack);
	}


	public void setStack(String line)
	{
		popEmAll();
		String [] splitLine = line.split(" ");
		for (int index = 0; index < splitLine.length; index++)
			stack.push(splitLine[index]);


		out.println(stack);
	}


	public void popEmAll()
	{
		while (!stack.isEmpty())
		{
			out.println(stack.pop());
		}
	}




}
