//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import static java.lang.System.*;

public class IteratorReplacerRunner
{
	public static void main ( String[] args )
	{
		IteratorReplacer ir = new IteratorReplacer("a b c a b c","a","+");
		System.out.println(ir);
		ir.replace();
		System.out.println(ir);
	}
}