import java.util.ArrayList;
import static java.lang.System.*;

public class IntQueueRunner
{
	public static void main ( String[] args )
	{
		IntQueue test = new IntQueue();
		test.add(5);
		test.add(7);
		test.add(9);
		System.out.println(test);
		System.out.println(test.isEmpty());
		System.out.println(test.remove());
		System.out.println(test.peek());
		System.out.println(test.remove());
		System.out.println(test.remove());
		System.out.println(test.isEmpty());
		System.out.println(test);
	}
}