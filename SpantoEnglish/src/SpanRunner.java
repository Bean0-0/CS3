import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanRunner
{
	public static void main( String args[] ) throws IOException
	{
		SpanishToEnglish trans = new SpanishToEnglish();
		System.out.println(trans.translate(""));
	}
}