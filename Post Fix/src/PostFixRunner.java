
// Do not change this code


import static java.lang.System.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PostFixRunner
{
	public static void main( String args[] ) throws IOException
	{
		File text = new File("Postfix.dat");
		Scanner scan = new Scanner(text);
		
		PostFix test = new PostFix();
		int numLines = scan.nextInt();
		scan.nextLine();
		
		
		for (int i=0; i < numLines; i++) {
			String entry = scan.nextLine();
			test.setExpression(entry);
			System.out.println(test);
			test.solve();
		}
				
		
	}
}
