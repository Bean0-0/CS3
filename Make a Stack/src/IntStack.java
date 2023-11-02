//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

//ArrayList of ints
//or
//array of ints

import java.util.ArrayList;
import static java.lang.System.*;

import java.util.ArrayList;
import static java.lang.System.*;


public class IntStack
{
	//pick your storage for the stack
	//you can use the an array or an ArrayList


	//option 1
	private int[] rayOfInts;
	private int numInts;


	//option 2
	private ArrayList<Integer> listOfInts;



	public IntStack()
	{
		listOfInts = new ArrayList<Integer>();
	}


	public void push(int item)
	{
		listOfInts.add(item);
	}


	public int pop()
	{
		if (listOfInts.isEmpty())
			return 0;


		return listOfInts.remove(listOfInts.size()-1);
	}


	public boolean isEmpty()
	{
		return listOfInts.isEmpty();
	}


	public int peek()
	{
		return listOfInts.get(listOfInts.size()-1);
	}


	public String toString()
	{
		StringBuilder stack = new StringBuilder("[");
		for (Integer listOfInt : listOfInts) stack.append(listOfInt).append(" ");


		return stack+"]";
	}
}
