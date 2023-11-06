import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQTestRunner
{
	public static void main ( String[] args )
	{
		PQTester test = new PQTester("one two three four five six seven");
		System.out.println("toString() - "+test);
		System.out.println("getMin() - "+test.getMin());	
		System.out.println("getNaturalOrder() - "+test.getNaturalOrder()+"\n\n");
	
		test.setPQ("one two three four five 1 2 3 4 5");
		System.out.println("toString() - "+test);
		System.out.println("getMin() - "+test.getMin());	
		System.out.println("getNaturalOrder() - "+test.getNaturalOrder()+"\n\n");
		
		test.setPQ("a b c d e f g h i j k l m n o p");
		System.out.println("toString() - "+test);
		System.out.println("getMin() - "+test.getMin());	
		System.out.println("getNaturalOrder() - "+test.getNaturalOrder()+"\n\n");
	}
}