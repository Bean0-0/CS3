import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;


public class PartList
{
	private TreeMap<Part, Integer> partsMap;

	public PartList()
	{
		partsMap = new TreeMap<Part, Integer>();
	}

	public PartList(String fileName)
	{
		this();
		try
		{
			Scanner file = new Scanner(new File("partinfo.dat"));


			while (file.hasNextLine()){
				Part a = new Part(file.nextLine());
				if (!partsMap.containsKey(a)){
					partsMap.put(a, 1);
				}
				else partsMap.put(a, partsMap.get(a)+1);
			}
			//add code here to read from the file
			//and add Parts to the map








		}
		catch( IOException e )  //Most specific exceptions must be listed 1st
		{
			out.println(e);
		}
		catch( RuntimeException e )
		{
			out.println(e);
		}
		catch( Exception e )
		{
			out.println(e);
		}
		finally
		{
			//no code needed here
		}
	}

	public String toString() {
		String output = "";


		for (Part x :
				partsMap.keySet()) {


			output += x + " - " + partsMap.get(x) + "\n";
		}


		return output;
	}
}
