import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class RelativesRunner
{
	public static void main( String args[] ) throws IOException
	{
		Relatives relatives = new Relatives();
		relatives.setPersonRelative("Jim Sally");
		relatives.setPersonRelative("Jim John");
		System.out.println(relatives);
	}
}