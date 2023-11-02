
// Do not change this code


import static java.lang.System.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StackTestRunner
{
	public static void main( String args[] ) throws IOException
	{
		File text = new File("StackTest.dat");
		Scanner scan = new Scanner(text);
		
		StackTest test = new StackTest();
		int numLines = scan.nextInt();
		scan.nextLine();
		
		
		for (int i=0; i < numLines; i++) {
			String entry = scan.nextLine();
			test.setStack(entry);
			System.out.println(test);
			test.popEmAll();
		}
				
		
	}
}
