import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		Acronyms acronyms = new Acronyms();

		acronyms.putEntry("TSO - Texas State Optical");
		acronyms.putEntry("PDA - Personal Display of Affection");
		acronyms.putEntry("RBI - Runs Batted In");
		acronyms.putEntry("SO - Strike Out");
		acronyms.putEntry("FG - Field Goal");
		acronyms.putEntry("CPU - Central Processing Unit");
		acronyms.putEntry("HD - Hard Drive");
		acronyms.putEntry("PU - Pick Up");

		System.out.println(acronyms.convert("I drove my PU to TSO to get a HD.  My CPU has a virus."));
	}
}