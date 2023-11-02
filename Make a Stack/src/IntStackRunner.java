
// Do not change this code

public class IntStackRunner {
	
	public static void main ( String[] args )
	{
		IntStack test = new IntStack();
		test.push(5);
		test.push(7);
		test.push(9);
		System.out.println(test);
		System.out.println(test.isEmpty());
		System.out.println(test.pop());
		System.out.println(test.peek());
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.isEmpty());
		System.out.println(test);

		
	}

}
